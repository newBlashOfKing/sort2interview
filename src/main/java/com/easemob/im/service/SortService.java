package com.easemob.im.service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public interface SortService {

    List<BigDecimal> sort(List<BigDecimal> numbers, HttpServletRequest request);
}
