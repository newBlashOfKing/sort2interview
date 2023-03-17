package com.easemob.im.service.impl;

import com.easemob.im.model.SortHistory;
import com.easemob.im.repository.SortHistoryRepository;
import com.easemob.im.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortHistoryRepository sortHistoryRepository;

    @Override
    public List<BigDecimal> sort(List<BigDecimal> numbers, HttpServletRequest request) {

        SortHistory sortHistory = new SortHistory();
        sortHistory.setSortBefore(numbers.toString());

        Collections.sort(numbers, Collections.reverseOrder());

        sortHistory.setSortAfter(numbers.toString());

        sortHistory.setIp(request.getRemoteAddr());

        sortHistoryRepository.save(sortHistory);

        return numbers;

    }
}
