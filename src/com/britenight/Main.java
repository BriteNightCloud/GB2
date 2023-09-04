package com.britenight;

import com.britenight.Model.Model;
import com.britenight.View.View;
import com.britenight.Presenter.Presenter;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Presenter presenter = new Presenter(model, view);
        presenter.start();
    }
}
