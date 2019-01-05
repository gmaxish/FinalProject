package com.MGrigorovich;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;


public class MyBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
//        String message1 = update.getMessage().getText();
//       // sendMsg(update.getMessage().getChatId().toString(), message1);
//
//
//        String command = update.getMessage().getText();
//
//        SendMessage message = new SendMessage();
//
//        if (command.equals("/myname")) {
//            System.out.println(update.getMessage().getFrom().getFirstName());
//            message.setText(update.getMessage().getFrom().getFirstName());
//        }
//        if (command.equals("/start")) {
//            System.out.println(update.getMessage().getFrom().getLastName());
//            message.setText(update.getMessage().getFrom().getLastName());
//        }
//        if (command.equals("/myfullname")) {
//            System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
//            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
//        }
//        message.setChatId(update.getMessage().getChatId());
//        try {
//            execute(message);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }


        Message message = update.getMessage();

        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/start":
                    sendMsg(message, "Здравствуйте, чем я могу помочь?");
                    break;
                case "==-> Записаться на маникюр <-==":
                    sendMsg(message, "На какую дату желаете оформить визит?");
                    break;
                case "21":
                    sendMsg(message, "На который час формить визит?");
                    break;
                case "22":
                    sendMsg(message, "На который час формить визит?");
                    break;
                case "23":
                    sendMsg(message, "На который час формить визит?");
                    break;
                 case "5":
                    sendMsg(message, "На который час формить визит?");
                    break;
                case "24":
                    sendMsg(message, "На который час формить визит?");
                    break;
                case "25":
                    sendMsg(message, "На который час формить визит?");
                    break;
                case "26":
                    sendMsg(message, "На который час формить визит?");
                    break;
                case "==-> Записаться на педекюр <-==":
                    sendMsg(message, "На какую дату желаете оформить визит?");
                    break;
                case "20":
                    sendMsg(message, "На который час формить визит?");
                default:
                    sendNotification(message, "Спасибо. Ваша заявка принята!");
            }
        }
        System.out.println(message.getText());
    }

    public void sendNotification(Message message, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {

        }
    }

    public void sendMsg(Message message, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try {
            if (!"Спасибо. Ваша заявка принята!".equals(s)) {
                setButtons(sendMessage);
            }
            if (sendMessage.getText().equals("На какую дату желаете оформить визит?")) {
                DayButton(sendMessage);
            } else setButtons(sendMessage);
            if (sendMessage.getText().equals("На который час формить визит?")) {
                HourButton(sendMessage);
            }
            execute(sendMessage);
        } catch (TelegramApiException e) {

        }
    }

    public void setButtons(SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("==-> Записаться на маникюр <-=="));
        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("==-> Записаться на педекюр <-=="));

        // Добавляемавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public void DayButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        Calendar calendar = Calendar.getInstance();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();

        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int[] cal = new int[31];
        LinkedList list = new LinkedList();

        for (int i = currentDay; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            cal[i] = i;
            if (i > currentDay) {
                String j = String.valueOf(i);
                list.add(j);
                keyboardFirstRow.add(new KeyboardButton(j));
            }
        }

        keyboard.add(keyboardFirstRow);

        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public void HourButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();

        int startWorkingDay = 9;
        int finishWorkingDay = 18;

        LinkedList list = new LinkedList();

        for (int i = startWorkingDay; i <= finishWorkingDay; i++) {
            if (i > startWorkingDay) {
                String j = i + ":00";
                list.add(j);
                keyboardFirstRow.add(new KeyboardButton(j));
            }
        }

        keyboard.add(keyboardFirstRow);

        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    private void setInline() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        buttons1.add(new InlineKeyboardButton().setText("Кнопка").setCallbackData(String.valueOf(17)));
        buttons.add(buttons1);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
    }

    public String getBotUsername() {
        return "mradminbot";
    }

    public String getBotToken() {
        return "653107232:AAFqPa0QLhlonaYvaGzKFk3nflsU2Pbhtss";
    }

}

