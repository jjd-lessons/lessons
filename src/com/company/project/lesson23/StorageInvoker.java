package com.company.project.lesson23;

import java.util.HashMap;
import java.util.Map;

public class StorageInvoker {
    private Map<String, Command> commands =
            new HashMap<>();

    public void setCommand(Command command) {
        commands.put(command.getCode(), command);
    }

    public void read(){
        commands.get("read").execute();
    }
}
