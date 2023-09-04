package com.test.datastruct.test;

abstract class Handler {
    protected Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(Request request);
}

class Request {
    private String type;
    private String content;

    public Request(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}

class ConcreteHandlerA extends Handler {
    public ConcreteHandlerA(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("TypeA")) {
            System.out.println("ConcreteHandlerA 处理了请求：" + request.getContent());
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}

class ConcreteHandlerB extends Handler {
    public ConcreteHandlerB(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("TypeB")) {
            System.out.println("ConcreteHandlerB 处理了请求：" + request.getContent());
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}

class ConcreteHandlerC extends Handler {
    public ConcreteHandlerC(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("TypeC")) {
            System.out.println("ConcreteHandlerC 处理了请求：" + request.getContent());
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}

public class ChainOfResponsibilityPatternDemo {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandlerA(null);
        Handler handler2 = new ConcreteHandlerB(handler1);
        Handler handler3 = new ConcreteHandlerC(handler2);

        Request request1 = new Request("TypeA", "Request A");
        Request request2 = new Request("TypeB", "Request B");
        Request request3 = new Request("TypeC", "Request C");
        Request request4 = new Request("TypeD", "Request D");

        handler3.handleRequest(request1);
        handler3.handleRequest(request2);
        handler3.handleRequest(request3);
        handler3.handleRequest(request4);
    }
}