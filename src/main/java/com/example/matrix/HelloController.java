package com.example.matrix;

import com.example.matrix.module.Matrix;
import com.example.matrix.module.MatrixException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//import static com.example.matrix.module.StringUtil.matrixToString;


public class HelloController {
    @FXML
    private TextArea matrix1Text, matrix2Text, result;

    @FXML
    private TextField x1, y1, x2, y2, rowIndex1, colIndex1, rowIndex2, colIndex2, addRowIndex1, addColIndex1,
            addRowIndex2, addColIndex2, elementIndexX1, elementIndexY1, elementValue1, elementIndexX2, elementIndexY2,
            elementValue2;

    @FXML
    private Button deleteFirstRow1, deleteLastRow1, deleteFirstCol1, deleteLastCol1, deleteFirstRow2, deleteLastRow2,
            deleteFirstCol2, deleteLastCol2, addition, subtraction, multiplication, division, deleteRowByIndex1,
            deleteColByIndex1, deleteRowByIndex2, deleteColByIndex2, addRow1, addCol1, addRow2, addCol2,
            changeElementByIndex1, changeElementByIndex2, fillRnd1, FillRndDotZero1, fillRnd2, FillRndDotZero2,
            Determinant1, Inverse1, Determinant2, Inverse2, Submit1, Submit2, addElementByIndex1, delElementByIndex1,
            addElementByIndex2, delElementByIndex2;

    @FXML
    void initialize() {
        deleteFirstRow1.setDisable(true);
        deleteLastRow1.setDisable(true);
        deleteFirstCol1.setDisable(true);
        deleteLastCol1.setDisable(true);
        deleteFirstRow2.setDisable(true);
        deleteLastRow2.setDisable(true);
        deleteFirstCol2.setDisable(true);
        deleteLastCol2.setDisable(true);
        addition.setDisable(true);
        subtraction.setDisable(true);
        multiplication.setDisable(true);
        division.setDisable(true);
        deleteRowByIndex1.setDisable(true);
        deleteColByIndex1.setDisable(true);
        deleteRowByIndex2.setDisable(true);
        deleteColByIndex2.setDisable(true);
        addRow1.setDisable(true);
        addCol1.setDisable(true);
        addRow2.setDisable(true);
        addCol2.setDisable(true);

        rowIndex1.setDisable(true);
        colIndex1.setDisable(true);
        rowIndex2.setDisable(true);
        colIndex2.setDisable(true);
        addRowIndex1.setDisable(true);
        addColIndex1.setDisable(true);
        addRowIndex2.setDisable(true);
        addColIndex2.setDisable(true);

        elementIndexX1.setDisable(true);
        elementIndexY1.setDisable(true);
        elementValue1.setDisable(true);
        elementIndexX2.setDisable(true);
        elementIndexY2.setDisable(true);
        elementValue2.setDisable(true);

        changeElementByIndex1.setDisable(true);
        changeElementByIndex2.setDisable(true);

        fillRnd1.setDisable(true);
        FillRndDotZero1.setDisable(true);
        fillRnd2.setDisable(true);
        FillRndDotZero2.setDisable(true);

        Determinant1.setDisable(true);
        Inverse1.setDisable(true);
        Determinant2.setDisable(true);
        Inverse2.setDisable(true);

        Submit1.setDisable(true);
        Submit2.setDisable(true);

        addElementByIndex1.setDisable(true);
        delElementByIndex1.setDisable(true);
        addElementByIndex2.setDisable(true);
        delElementByIndex2.setDisable(true);

        matrix1Text.setText("");
        matrix2Text.setText("");
        result.setText("");
    }

    private Matrix matrix1;
    private Matrix matrix2;

    @FXML
    protected void createMatrix1() {
        try {
            try {
                result.setText("");
                this.matrix1 = new  Matrix(Integer.parseInt(x1.getText()), Integer.parseInt(y1.getText()));
                matrix1Text.setText(this.matrix1.toString());
                deleteFirstRow1.setDisable(false);
                deleteLastRow1.setDisable(false);
                deleteFirstCol1.setDisable(false);
                deleteLastCol1.setDisable(false);
                deleteRowByIndex1.setDisable(false);
                deleteColByIndex1.setDisable(false);
                addRow1.setDisable(false);
                addCol1.setDisable(false);
                rowIndex1.setDisable(false);
                colIndex1.setDisable(false);
                addRowIndex1.setDisable(false);
                addColIndex1.setDisable(false);

                elementIndexX1.setDisable(false);
                elementIndexY1.setDisable(false);
                elementValue1.setDisable(false);
                changeElementByIndex1.setDisable(false);

                fillRnd1.setDisable(false);
                FillRndDotZero1.setDisable(false);

                Determinant1.setDisable(false);
                Inverse1.setDisable(false);

                Submit1.setDisable(false);

                addElementByIndex1.setDisable(false);
                delElementByIndex1.setDisable(false);

                if (matrix1 != null && matrix2 != null) {
                    addition.setDisable(false);
                    subtraction.setDisable(false);
                    multiplication.setDisable(false);
                    division.setDisable(false);
                }
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести размеры матрицы." + "\n" + e);
        }
    }

    @FXML
    protected void createMatrix2() {
        try {
            try {
                result.setText("");
                this.matrix2 = new Matrix(Integer.parseInt(x2.getText()), Integer.parseInt(y2.getText()));
                matrix2Text.setText(this.matrix2.toString());
                deleteFirstRow2.setDisable(false);
                deleteLastRow2.setDisable(false);
                deleteFirstCol2.setDisable(false);
                deleteLastCol2.setDisable(false);
                deleteRowByIndex2.setDisable(false);
                deleteColByIndex2.setDisable(false);
                addRow2.setDisable(false);
                addCol2.setDisable(false);
                rowIndex2.setDisable(false);
                colIndex2.setDisable(false);
                addRowIndex2.setDisable(false);
                addColIndex2.setDisable(false);

                elementIndexX2.setDisable(false);
                elementIndexY2.setDisable(false);
                elementValue2.setDisable(false);
                changeElementByIndex2.setDisable(false);

                fillRnd2.setDisable(false);
                FillRndDotZero2.setDisable(false);

                Determinant2.setDisable(false);
                Inverse2.setDisable(false);

                Submit2.setDisable(false);

                addElementByIndex2.setDisable(false);
                delElementByIndex2.setDisable(false);

                if (matrix1 != null && matrix2 != null) {
                    addition.setDisable(false);
                    subtraction.setDisable(false);
                    multiplication.setDisable(false);
                    division.setDisable(false);
                }
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести размеры матрицы." + "\n" + e);
        }
    }

    @FXML
    protected void addElementByIndex1() {
        try {
            try {
                result.setText("");
                matrix1.addElementByIndex(Integer.parseInt(elementIndexX1.getText()),
                        Integer.parseInt(elementIndexY1.getText()), Double.parseDouble(elementValue1.getText()));
                matrix1Text.setText(matrix1.toString());
            } catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("""
                    Нужно ввести индекс элемента (строка, колонка) и его значеие.\s
                    Только число.
                    Разделителем дробной части от целой должна являтся точка.""");
        }
    }

    @FXML
    protected void delElementByIndex1() {
        try {
            try {
                result.setText("");
                matrix1.delElementByIndex(Integer.parseInt(elementIndexX1.getText()),
                        Integer.parseInt(elementIndexY1.getText()));
                matrix1Text.setText(matrix1.toString());
            } catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("""
                    Нужно ввести индекс элемента (строка, колонка) и его значеие.\s
                    Только число.
                    Разделителем дробной части от целой должна являтся точка.""");
        }
    }

    @FXML
    protected void addElementByIndex2() {
        try {
            try {
                result.setText("");
                matrix2.addElementByIndex(Integer.parseInt(elementIndexX2.getText()),
                        Integer.parseInt(elementIndexY2.getText()), Double.parseDouble(elementValue2.getText()));
                matrix2Text.setText(matrix2.toString());
            } catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("""
                    Нужно ввести индекс элемента (строка, колонка) и его значеие.\s
                    Только число.
                    Разделителем дробной части от целой должна являтся точка.""");
        }
    }

    @FXML
    protected void delElementByIndex2() {
        try {
            try {
                result.setText("");
                matrix2.delElementByIndex(Integer.parseInt(elementIndexX2.getText()),
                        Integer.parseInt(elementIndexY2.getText()));
                matrix2Text.setText(matrix2.toString());
            } catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("""
                    Нужно ввести индекс элемента (строка, колонка) и его значеие.\s
                    Только число.
                    Разделителем дробной части от целой должна являтся точка.""");
        }
    }

    @FXML
    protected void submit1() {
        try {
            try {
                this.matrix1 = Matrix.parse(matrix1Text.getText());
            } catch (MatrixException e) {
                result.setText(e.cause());
            }
        } catch (Exception e) {
            result.setText("Непредвиденная ошибка" + "\n" + e);
        }
    }

    @FXML
    protected void submit2() {
        try {
            try {
                this.matrix2 = Matrix.parse(matrix2Text.getText());
            } catch (MatrixException e) {
                result.setText(e.cause());
            }
        } catch (Exception e) {
            result.setText("Непредвиденная ошибка" + e);
        }
    }

    @FXML
    protected void fillRnd1() {
        try {
            result.setText("");
            matrix1.fillRndVal();
            matrix1Text.setText(matrix1.toString());
        } catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    protected void FillRndDotZero1() {
        try {
            result.setText("");
            matrix1.fillRndDotZero();
            matrix1Text.setText(matrix1.toString());
        } catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    protected void fillRnd2() {
        try {
            result.setText("");
            matrix2.fillRndVal();
            matrix2Text.setText(matrix2.toString());
        } catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    protected void FillRndDotZero2() {
        try {
            result.setText("");
            matrix2.fillRndDotZero();
            matrix2Text.setText(matrix2.toString());
        } catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    protected void deleteFirstRow1() {
        try {
            try {
                result.setText("");
                this.matrix1.removeFirstRow();
                matrix1Text.setText(matrix1.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (Exception e) {
            result.setText("" + "\n" + e);
        }
    }

    @FXML
    protected void deleteFirstRow2() {
        try {
            try {
                result.setText("");
                this.matrix2.removeFirstRow();
                matrix2Text.setText(matrix2.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (Exception e) {
            result.setText("" + "\n" + e);
        }
    }

    @FXML
    protected void deleteLastRow1() {
        try {
            try {
                result.setText("");
                this.matrix1.removeLastRow();
                matrix1Text.setText(matrix1.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (Exception e) {
            result.setText("" + "\n" + e);
        }
    }

    @FXML
    protected void deleteLastRow2() {
        try {
            try {
                result.setText("");
                this.matrix2.removeLastRow();
                matrix2Text.setText(matrix2.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (Exception e) {
            result.setText("" + "\n" + e);
        }
    }

    @FXML
    protected void deleteFirstCol1() {
        try {
            try {
                result.setText("");
                this.matrix1.removeFirstColumn();
                matrix1Text.setText(matrix1.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (Exception e) {
            result.setText("" + "\n" + e);
        }
    }

    @FXML
    protected void deleteFirstCol2() {
        try {
            try {
                result.setText("");
                this.matrix2.removeFirstColumn();
                matrix2Text.setText(matrix2.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (Exception e) {
            result.setText("" + "\n" + e);
        }
    }

    @FXML
    protected void deleteLastCol1() {
        try {
            try {
                result.setText("");
                this.matrix1.removeLastColumn();
                matrix1Text.setText(matrix1.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (Exception e) {
            result.setText("" + "\n" + e);
        }
    }

    @FXML
    protected void deleteLastCol2() {
        try {
            try {
                result.setText("");
                this.matrix2.removeLastColumn();
                matrix2Text.setText(matrix2.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (Exception e) {
            result.setText("" + "\n" + e);
        }
    }

    @FXML
    protected void deleteRowByIndex1() {
        try {
            try {
                result.setText("");
                this.matrix1.removeRowByIndex(Integer.parseInt(rowIndex1.getText()));
                matrix1Text.setText(matrix1.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести индекс строки, которую нужно удалить." + "\n" + e);
        }
    }

    @FXML
    protected void deleteRowByIndex2() {
        try {
            try {
                result.setText("");
                this.matrix2.removeRowByIndex(Integer.parseInt(rowIndex2.getText()));
                matrix2Text.setText(matrix2.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести индекс строки, которую нужно удалить." + "\n" + e);
        }
    }

    @FXML
    protected void deleteColByIndex1() {
        try {
            try {
                result.setText("");
                this.matrix1.removeColumnByIndex(Integer.parseInt(colIndex1.getText()));
                matrix1Text.setText(matrix1.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести индекс колонки, которую нужно удалить." + "\n" + e);
        }
    }

    @FXML
    protected void deleteColByIndex2() {
        try {
            try {
                result.setText("");
                this.matrix2.removeColumnByIndex(Integer.parseInt(colIndex2.getText()));
                matrix2Text.setText(matrix2.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести индекс колонки, которую нужно удалить." + "\n" + e);
        }
    }

    @FXML
    protected void addRowByIndex1() {
        try {
            try {
                result.setText("");
                this.matrix1.addRowByIndex(Integer.parseInt(addRowIndex1.getText()));
                matrix1Text.setText(matrix1.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести индекс строки, которую нужно добавить." + "\n" + e);
        }
    }

    @FXML
    protected void addRowByIndex2() {
        try {
            try {
                result.setText("");
                this.matrix2.addRowByIndex(Integer.parseInt(addRowIndex2.getText()));
                matrix2Text.setText(matrix2.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести индекс строки, которую нужно добавить." + "\n" + e);
        }
    }

    @FXML
    protected void addColumnByIndex1() {
        try {
            try {
                result.setText("");
                this.matrix1.addColumnByIndex(Integer.parseInt(addColIndex1.getText()));
                matrix1Text.setText(matrix1.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести индекс колонки, которую нужно добавить." + "\n" + e);
        }
    }

    @FXML
    protected void addColumnByIndex2() {
        try {
            try {
                result.setText("");
                this.matrix2.addColumnByIndex(Integer.parseInt(addColIndex2.getText()));
                matrix2Text.setText(matrix2.toString());
            }
            catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("Нужно ввести индекс колонки, которую нужно добавить." + "\n" + e);
        }
    }

    @FXML
    protected void addition() {
        try {
            result.setText("");
            Matrix matrix = Matrix.addition(matrix1, matrix2);
            result.setText(matrix.toString());
        } catch (MatrixException e) {
            result.setText(e.cause());
        }
    }

    @FXML
    protected void subtraction() {
        try {
            result.setText("");
            Matrix matrix = Matrix.subtraction(matrix1, matrix2);
            result.setText(matrix.toString());
        } catch (MatrixException e) {
            result.setText(e.cause());
        }
    }

    @FXML
    protected void multiplication() {
        try {
            result.setText("");
            Matrix matrix = Matrix.multiplication(matrix1, matrix2);
            result.setText(matrix.toString());
        } catch (MatrixException e) {
            result.setText(e.cause());
        }
    }

    @FXML
    protected void division() {
        try {
            result.setText("");
            Matrix matrix = Matrix.division(matrix1, matrix2);
            result.setText(matrix.toString());
        } catch (MatrixException e) {
            result.setText(e.cause());
        }
    }

    @FXML
    protected void determinant1() {
        try {
            result.setText("");
            double det = matrix1.determinant();
            result.setText(String.valueOf(det));
        } catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    protected void inverse1() {
        try {
            result.setText("");
            result.setText(matrix1.inverse().toString());
        } catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    protected void determinant2() {
        try {
            result.setText("");
            double det = matrix2.determinant();
            result.setText(String.valueOf(det));
        } catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    protected void inverse2() {
        try {
            result.setText("");
            result.setText(matrix2.inverse().toString());
        } catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    protected void changeElementByIndex1() {
        try {
            try {
                result.setText("");
                matrix1.changeElementByIndex(Integer.parseInt(elementIndexX1.getText()),
                        Integer.parseInt(elementIndexY1.getText()), Double.parseDouble(elementValue1.getText()));
                matrix1Text.setText(matrix1.toString());
            } catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("""
                    Нужно ввести индекс элемента (строка, колонка) и его значеие.\s
                    Только число.
                    Разделителем дробной части от целой должна являтся точка.""");
        }
    }

    @FXML
    protected void changeElementByIndex2() {
        try {
            try {
                result.setText("");
                matrix2.changeElementByIndex(Integer.parseInt(elementIndexX2.getText()),
                        Integer.parseInt(elementIndexY2.getText()), Double.parseDouble(elementValue2.getText()));
                matrix2Text.setText(matrix2.toString());
            } catch (MatrixException e) {
                result.setText(e.cause());
            }
        }
        catch (NumberFormatException e) {
            result.setText("""
                    Нужно ввести индекс элемента (строка, колонка) и его значеие.\s
                    Только число.
                    Разделителем дробной части от целой должна являтся точка.""");
        }
    }
}