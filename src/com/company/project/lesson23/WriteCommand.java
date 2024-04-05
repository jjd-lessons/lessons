package com.company.project.lesson23;

public class WriteCommand extends Command{
    public WriteCommand(String code) {
        super(code);
    }

    @Override
    void execute(Storage storage) {
        storage.open();
        storage.write();
    }
}
