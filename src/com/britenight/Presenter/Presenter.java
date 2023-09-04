package com.britenight.Presenter;

import com.britenight.View.View;
import com.britenight.Model.Model;

import java.io.IOException;
import java.util.InputMismatchException;
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
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        view.promptToyInfo();
                        String toyInfo = scanner.nextLine();
                        String[] toyData = toyInfo.split(" ");

                        if (toyData.length != 3) {
                            throw new IllegalArgumentException("Некорректные данные об игрушке.");
                        }

                        int id = Integer.parseInt(toyData[0]);
                        int weight = Integer.parseInt(toyData[1]);
                        String name = toyData[2];
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
                        String filePath = scanner.nextLine();
                        model.saveToFile(filePath);
                        view.showSuccessMessage("Данные сохранены в файл.");
                        break;
                    case 4:
                        return; // Завершить программу
                    default:
                        view.showErrorMessage("Неверный выбор. Пожалуйста, выберите действие из меню.");
                        break;
                }
            } catch (NumberFormatException e) {
                view.showErrorMessage("Некорректные числовые данные.");
            } catch (IllegalArgumentException e) {
                view.showErrorMessage(e.getMessage());
            } catch (IOException e) {
                view.showErrorMessage("Ошибка при сохранении данных в файл.");
            }

            view.showMenu();
        }
    }
}
