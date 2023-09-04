package com.britenight.View;

public class View {
    public void showMenu() {
        System.out.println("\nМеню");
        System.out.println("1. Добавить игрушку");
        System.out.println("2. Получить игрушку");
        System.out.println("3. Сохранить данные в файл");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");
    }

    public void promptToyInfo() {
        System.out.print("Введите информацию об игрушке (id weight name): ");
    }

    public void promptFilePath() {
        System.out.print("Введите путь к файлу: ");
    }

    public void showSuccessMessage(String message) {
        System.out.println("Успешно: " + message);
    }

    public void showErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }
}