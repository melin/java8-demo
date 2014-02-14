package com.ustcinfo.java8.Consumer;

import java.util.function.Consumer;

/**
 * Created by melin on 14-2-1.
 */
public class TrainWreckPatternLambda {

    public static void main(String[] args) {
        Mailer.send( mailer -> {
            mailer.to("to@example.com")
                    .from("from@exmaple.com")
                    .subject("Some subject")
                    .body("Some content");
        });
    }

    private static class Mailer{

        private Mailer(){

        }
        public Mailer to(String address){
            System.out.println("To: "+address);
            return this;
        }
        public Mailer from(String address){
            System.out.println("From: "+address);
            return this;
        }
        public Mailer subject(String sub){
            System.out.println("Subject: "+sub);
            return this;
        }
        public Mailer body(String body){
            System.out.println("Body: "+body);
            return this;
        }
        public static void send(Consumer<Mailer> mailerOperator){
            Mailer mailer = new Mailer();
            mailerOperator.accept(mailer);
            System.out.println("Sending ...");
        }
    }

}