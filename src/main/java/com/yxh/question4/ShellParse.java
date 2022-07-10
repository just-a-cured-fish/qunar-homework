package com.yxh.question4;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 11:01
 */
public class ShellParse {

    private final Splitter SPLITTER = Splitter.on("|");

    private final Splitter SPLITTERWITHN = Splitter.on("&&");

    private final Splitter SPLITTER2 = Splitter.onPattern("\\s+");

    void run(String command) throws IOException {
        Iterator<String> commands = SPLITTERWITHN.split(command).iterator();
        while(commands.hasNext()){
            singleRun(commands.next());
        }
    }
    void singleRun(String command) throws IOException{
        //首先分割管道命令
        Iterator<String> commands = SPLITTER.split(command).iterator();
        //对于分割出的命令的第一个命令直接执行出结果
        List<String> commandList = SPLITTER2.splitToList(commands.next());

        //执行管道 符号之前的第一个命令 比如cat
        String commandPre = commandList.get(0);

        //解析出此命令参数列表
        List<String> parmsList = Lists.newArrayList(commandList);
        parmsList.remove(0);
        parmsList.remove(parmsList.size() - 1);

        //获取命令中的文件路径
        String filePath = commandList.get(commandList.size() - 1);
        if (filePath.trim().isEmpty()) {
            filePath = commandList.get(commandList.size() - 2);
        }

        //获取了命令名称、参数列表，文件路径以后就额可以直接开始运行
        File file = new File(filePath);
        ShellFactory shellFactory = new ShellFactory();
        List<String> results = shellFactory.buildService(commandPre).run(parmsList, file);

        //第一个命令执行后如果还有命令，则后面都是管道命令，以前面的命令为输入
        while (commands.hasNext()) {
            commandList = SPLITTER2.splitToList(commands.next());
            //解析出命令名称
            commandPre = commandList.get(1);
            //解析参数列表
            parmsList = Lists.newArrayList(commandList);
            parmsList.remove(0);
            parmsList.remove(0);
            //以管道方式运行
            results = shellFactory.buildService(commandPre).runWithPipe(parmsList, results);
        }
        results.forEach(line -> {
            System.out.println(line);
        });
    }
}
