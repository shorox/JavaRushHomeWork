package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sharov on 14.01.2016.
 */
public class BotClient extends Client {
    public class BotSocketThread extends Client.SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if(message.contains(":")) {
                String userName = message.substring(0, message.indexOf(": "));
                String text = message.substring(message.indexOf(": ") + 2);
                SimpleDateFormat simpleDateFormat = null;
                if (text.equals("дата")) simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                else if (text.equals("день")) simpleDateFormat = new SimpleDateFormat("d");
                else if (text.equals("месяц")) simpleDateFormat = new SimpleDateFormat("MMMM");
                else if (text.equals("год")) simpleDateFormat = new SimpleDateFormat("YYYY");
                else if (text.equals("время")) simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                else if (text.equals("час")) simpleDateFormat = new SimpleDateFormat("H");
                else if (text.equals("минуты")) simpleDateFormat = new SimpleDateFormat("m");
                else if (text.equals("секунды")) simpleDateFormat = new SimpleDateFormat("s");
                if (simpleDateFormat != null)
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return new Date().toLocaleString().substring(0,10) + "_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
