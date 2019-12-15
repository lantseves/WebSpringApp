package ru.lantsev.model.entry;

//Статусы жизненного цикла блюда
public enum StatusOrder {
    NEW, // Новый заказ
    ORDERED, // Заказ подтвержден
    IN_WORK, // Повор готовит заказ
    COOKED, // Заказ готов к выдаче
    DONE, // Заказ передан посетителю
    CANCELED // Заказ отменен
}
