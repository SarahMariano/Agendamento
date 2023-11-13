package com.sarah;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrincipalController {
    private int semanaSelecionada = 0;
    @FXML
    private Label LabelDataDom;
    @FXML
    private Label LabelDataSeg;
    @FXML
    private Label LabelDataTer;
    @FXML
    private Label LabelDataQua;
    @FXML
    private Label LabelDataQui;
    @FXML
    private Label LabelDataSex;
    @FXML
    private Label LabelDataSab;
    private List<Label> labelsData = new ArrayList<>();

    /**
     * 
     */
    @FXML
    private void initialize() {
        labelsData.add(LabelDataDom);
        labelsData.add(LabelDataSeg);
        labelsData.add(LabelDataTer);
        labelsData.add(LabelDataQua);
        labelsData.add(LabelDataQui);
        labelsData.add(LabelDataSex);
        labelsData.add(LabelDataSab);
        preencherLabels();
    }

    private void preencherLabels() {
        LocalDate dataAtual = LocalDate.now();
        dataAtual = dataAtual.plusDays(semanaSelecionada);
        LocalDate[] datasDaSemana = obterDatasDaSemana(dataAtual);
        int i = 0;
        for (LocalDate data : datasDaSemana) {
            String dataFormatada = formatarData(data);
            labelsData.get(i).setText(dataFormatada);
            i++;
        }
    }

    public static String formatarData(LocalDate data) {
        // Definir o formato desejado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

        // Formatar a data
        return data.format(formatter);
    }

    public static LocalDate[] obterDatasDaSemana(LocalDate data) {
        LocalDate[] datasDaSemana = new LocalDate[7];
        DayOfWeek diaDaSemana = data.getDayOfWeek();
        // Retrocede para o domingo
        LocalDate domingo = data.minusDays(diaDaSemana.getValue() - 1);

        // Preenche o array com as datas da semana
        for (int i = 0; i < 7; i++) {
            datasDaSemana[i] = domingo.plusDays(i - 1);
        }

        return datasDaSemana;
    }

    @FXML
    private void semanaAnterior() {
        semanaSelecionada = semanaSelecionada - 7;
        preencherLabels();
    }

    @FXML
    private void proximaSemana() {
        semanaSelecionada = semanaSelecionada + 7;
        preencherLabels();
    }
}