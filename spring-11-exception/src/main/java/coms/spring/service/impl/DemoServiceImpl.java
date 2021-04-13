package coms.spring.service.impl;

import coms.spring.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @ClassName:DemoServiceImpl
 * @Author Mr.guo
 * @Date 2021/4/12 21:17
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public void show() {
        int a = 1/0;
    }
}
