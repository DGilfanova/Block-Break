package graphics.controllers;

import javafx.scene.input.MouseEvent;

public class StartController {

    public void startAction(MouseEvent mouseEvent) {

        System.out.println(1);
        //запускаем заставку, избегаем статики
        //Шлем серверу первое сообщение "рукопожатие"
        //Получаем ответ
        //Проверяем, что это ответ на рукопожатие
        //меняем сцену или ждем подключение другого игрока
    }
}
