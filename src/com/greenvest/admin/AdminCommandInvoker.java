// used to run the admin command and storing their history
// each command is recorded for viewing


package com.greenvest.admin;

import com.greenvest.patterns.AdminCommand;
import java.util.ArrayList;
import java.util.List;

public class AdminCommandInvoker {

    //  list history
    private List<String> history = new ArrayList<>();

    //  execute admin command
    public void run(AdminCommand cmd) {
        cmd.execute();
        history.add(cmd.getName());
    }

    // display history
    public void showHistory() {
        for (String h : history) {
            System.out.println(h);
        }
    }
}
