package com.britenight.Presenter;

import com.britenight.View.View;
import com.britenight.Model.Model;

import java.util.Scanner;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        view.showMenu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    view.promptToyInfo();
                    scanner.nextLine();
                    String toyInfo = scanner.nextLine();
                    int id = Integer.parseInt(toyInfo.split(" ")[0]);
                    int weight = Integer.parseInt(toyInfo.split(" ")[1]);
                    String name = toyInfo.split(" ")[2];
                    model.put(id, weight, name);
                    view.showSuccessMessage("Игрушка добавлена.");
                    break;
                case 2:
                    int toyId = model.get();
                    if (toyId != -1) {
                        view.showSuccessMessage("Игрушка получена. ID: " + toyId);
                    } else {
                        view.showErrorMessage("Нет доступных игрушек.");
                    }
                    break;
                case 3:
                    view.promptFilePath();
                    String filePath = scanner.next();
                    model.saveToFile(filePath);
                    view.showSuccessMessage("Данные сохранены в файл.");
                    break;
                case 4:
                    return; // Завершить программу
                default:
                    view.showErrorMessage("Неверный выбор. Пожалуйста, выберите действие из меню.");
                    break;
            }

            view.showMenu();
        }
    }
}
