package com.yxh.question2;

import com.yxh.core.entity.CountBean;
import com.yxh.question2.impl.AvailableCodeCountServiceImpl;
import com.yxh.question2.impl.MutiiLineCountServiceImpl;
import com.yxh.question2.impl.SingleLineCountServiceImpl;
import com.yxh.question2.impl.SpaceCodeCountServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/10 17:02
 */
public class CodeCountChain {

    private final static Integer ZERO=0;
    private static List<CodeCountService> codeCountServices=new ArrayList<>();

    static {
        codeCountServices.add(new SpaceCodeCountServiceImpl());
        codeCountServices.add(new SingleLineCountServiceImpl());
        codeCountServices.add(new MutiiLineCountServiceImpl());
        codeCountServices.add(new AvailableCodeCountServiceImpl());
    }

    public static Integer parse(List<String> lines){
        CountBean countBean=new CountBean(0,0);
        while(countBean.getIndex()<lines.size()){
            for(int i=0;i<codeCountServices.size();i++){
                if(!codeCountServices.get(i).count(lines,countBean).equals(ZERO)){
                    break;
                }
            }
        }
        codeCountServices.forEach(codeCountService -> {
            codeCountService.printCount();
        });

        return codeCountServices.get(3).getCount();
    }
}
