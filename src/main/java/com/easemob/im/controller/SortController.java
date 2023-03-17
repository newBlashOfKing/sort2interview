package com.easemob.im.controller;

import com.easemob.im.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class SortController {

    @Value("${sort.number.size:100}")
    private int subscribeUserBatchSize;

    @Autowired
    private SortService sortService;

    @RequestMapping("/sort")
    private List<BigDecimal> sort(@RequestBody List<BigDecimal> numbers, HttpServletRequest request) {

        if (numbers.size() > subscribeUserBatchSize) {
            throw new IllegalArgumentException(
                    "sort size is not more than " + subscribeUserBatchSize);
        }

        if (numbers.size() == 1) {
            return numbers;
        }

        return sortService.sort(numbers,request);

    }
}
