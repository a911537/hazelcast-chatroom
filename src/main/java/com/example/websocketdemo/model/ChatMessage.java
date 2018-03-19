package com.example.websocketdemo.model;

import java.io.Serializable;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
public class ChatMessage implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 994078468190720338L;
	
	private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
