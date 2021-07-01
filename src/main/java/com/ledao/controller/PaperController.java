package com.ledao.controller;

import com.ledao.entity.*;
import com.ledao.service.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 试卷Controller层
 *
 * @author LeDao
 * @company
 * @create 2021-06-30 20:55
 */
@CrossOrigin
@RestController
@RequestMapping("/paper")
public class PaperController {

    @Resource
    private PaperService paperService;

    @Resource
    private QuestionService questionService;

    @Resource
    private PaperQuestionService paperQuestionService;

    @Resource
    private AnswerService answerService;

    /**
     * 添加试卷以及该试卷的试题
     *
     * @param paper
     * @return
     */
    @RequestMapping("/add")
    public Map<String, Object> add(Paper paper) {
        Map<String, Object> resultMap = new HashMap<>(16);
        paperService.add(paper);
        Paper lastPaper = paperService.findByUserIdLastOne(paper.getUserId());
        List<Question> allSingleQuestionList = questionService.getQuestionByCourseIdAndQuestionType(paper.getCourseId(), "单选题");
        List<Question> allFillQuestionList = questionService.getQuestionByCourseIdAndQuestionType(paper.getCourseId(), "填空题");
        //打乱题目顺序,实现随机选题
        Collections.shuffle(allSingleQuestionList);
        Collections.shuffle(allFillQuestionList);
        List<PaperQuestion> resultSingleQuestionList = new ArrayList<>();
        List<PaperQuestion> resultFillQuestionList = new ArrayList<>();
        //添加15道单选题
        for (int i = 0; i < 15; i++) {
            PaperQuestion paperQuestion = new PaperQuestion();
            Question question = allSingleQuestionList.get(i);
            paperQuestion.setPaperId(lastPaper.getId());
            paperQuestion.setQuestionId(question.getId());
            paperQuestion.setCourseName("单选题");
            paperQuestionService.add(paperQuestion);
            paperQuestion.setQuestion(questionService.findById(paperQuestion.getQuestionId()));
            List<Answer> answerList = answerService.getAnswerByQuestionId(paperQuestion.getQuestionId());
            paperQuestion.setAnswerList(answerList);
            resultSingleQuestionList.add(paperQuestion);
        }
        //添加5道填空题
        for (int i = 0; i < 5; i++) {
            PaperQuestion paperQuestion = new PaperQuestion();
            Question question = allFillQuestionList.get(i);
            paperQuestion.setPaperId(lastPaper.getId());
            paperQuestion.setQuestionId(question.getId());
            paperQuestion.setCourseName("填空题");
            paperQuestionService.add(paperQuestion);
            paperQuestion.setQuestion(questionService.findById(paperQuestion.getQuestionId()));
            List<Answer> answerList = answerService.getAnswerByQuestionId(paperQuestion.getQuestionId());
            paperQuestion.setAnswerList(answerList);
            resultFillQuestionList.add(paperQuestion);
        }
        resultMap.put("resultSingleQuestionList", resultSingleQuestionList);
        resultMap.put("resultFillQuestionList", resultFillQuestionList);
        return resultMap;
    }

    /**
     * 交卷
     *
     * @param userId
     * @param questionSingleStr
     * @param questionFillStr
     * @return
     */
    @RequestMapping("/submitPaper")
    public Map<String, Object> submitPaper(Integer userId, String questionSingleStr, String questionFillStr) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Integer score = 0;
        Paper lastPaper = paperService.findByUserIdLastOne(userId);
        String[] questionSingleArr = questionSingleStr.split(",");
        String[] questionFillArr = questionFillStr.split(",");
        List<PaperQuestion> singleList = paperQuestionService.getListByPaperIdAndCourseName(lastPaper.getId(), "单选题");
        List<PaperQuestion> fillList = paperQuestionService.getListByPaperIdAndCourseName(lastPaper.getId(), "填空题");
        for (int i = 0; i < singleList.size(); i++) {
            //获取该试卷试题的答案集合
            List<Answer> answerList = answerService.getAnswerByQuestionId(singleList.get(i).getQuestionId());
            for (int i1 = 0; i1 < answerList.size(); i1++) {
                if (answerList.get(i1).getIsTrue() == 1) {
                    //设置试卷试题的正确答案序号,第一个就是1
                    singleList.get(i).setTrueAnswerNum(i1 + 1);
                    break;
                }
            }
            if (singleList.get(i).getTrueAnswerNum() == Integer.parseInt(questionSingleArr[i])) {
                singleList.get(i).setScore(5);
                PaperQuestion paperQuestion = singleList.get(i);
                paperQuestion.setScore(5);
                //修改
                paperQuestionService.update(paperQuestion);
            }
            PaperQuestion paperQuestion = singleList.get(i);
            paperQuestion.setAnswer(questionSingleArr[i]);
            paperQuestionService.update(paperQuestion);
        }
        for (int i = 0; i < fillList.size(); i++) {
            fillList.get(i).setTrueAnswerStr(answerService.getAnswerByQuestionId(fillList.get(i).getQuestionId()).get(0).getContent());
            if (fillList.get(i).getTrueAnswerStr().equals(questionFillArr[i])) {
                fillList.get(i).setScore(5);
                PaperQuestion paperQuestion = fillList.get(i);
                paperQuestion.setScore(5);
                paperQuestionService.update(paperQuestion);
            }
            PaperQuestion paperQuestion = fillList.get(i);
            paperQuestion.setAnswer(questionFillArr[i]);
            paperQuestionService.update(paperQuestion);
        }
        for (PaperQuestion paperQuestion : singleList) {
            score += paperQuestion.getScore();
        }
        for (PaperQuestion paperQuestion : fillList) {
            score += paperQuestion.getScore();
        }
        lastPaper.setScore(score);
        paperService.update(lastPaper);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据用户id获取试卷(分页)
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getListFindByUserId")
    public Map<String, Object> getListFindByUserId(Integer userId, @RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "size",required = false)Integer size) {
        PageBean pageBean = new PageBean(page, size);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("userId", userId);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Paper> paperList = paperService.list(map);
        resultMap.put("total", paperService.getCount(map));
        resultMap.put("rows", paperList);
        return resultMap;
    }

    /**
     * 根据id获取试卷
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Map<String, Object> findById(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Paper paper = paperService.findById(id);
        List<PaperQuestion> singleList = paperQuestionService.getListByPaperIdAndCourseName(id, "单选题");
        List<PaperQuestion> fillList = paperQuestionService.getListByPaperIdAndCourseName(id, "填空题");
        for (PaperQuestion paperQuestion : singleList) {
            Question question = questionService.findById(paperQuestion.getQuestionId());
            paperQuestion.setQuestion(question);
            List<Answer> answerList = answerService.getAnswerByQuestionId(paperQuestion.getQuestionId());
            paperQuestion.setAnswerList(answerList);
        }
        for (PaperQuestion paperQuestion : fillList) {
            Question question = questionService.findById(paperQuestion.getQuestionId());
            paperQuestion.setQuestion(question);
            List<Answer> answerList = answerService.getAnswerByQuestionId(paperQuestion.getQuestionId());
            paperQuestion.setAnswerList(answerList);
            paperQuestion.setTrueAnswerStr(answerService.getAnswerByQuestionId(paperQuestion.getQuestionId()).get(0).getContent());
        }
        resultMap.put("singleList", singleList);
        resultMap.put("fillList", fillList);
        resultMap.put("paper", paper);
        return resultMap;
    }
}
