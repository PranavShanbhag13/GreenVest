//  interface for admin command
//  commands to executed is implemented in this interface

package com.greenvest.patterns;
//  execute command
public interface AdminCommand {
    void execute();
    String getName();
}
