/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsociadosWin;

import Asociados.*;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.scene.control.CheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Jesus
 */
public class JFrameAsociados extends javax.swing.JFrame {

    /**
     * Creates new form JFrameAsociados
     */
    public JFrameAsociados() {
        initComponents();
        iniciarAsociados();
        cargarListaAsociado();
        iniciarMisComponentes();

    }
    // <editor-fold defaultstate="collapsed" desc="Mis variables"> 
    private boolean todos;
    private boolean Alumnos;
//    //private boolean asd;
    // </ editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Clases Listener">
    private class gestorLista implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            jListListaAsociadosValueChanged(e);
            jButtonEliminarAsociado.setEnabled(jListListaAsociados.getSelectedIndex()>=0);
        }
    }

    private class gestorEliminarEmpleado implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Object indice = Asociado.listaAsociados.getElementAt(jListListaAsociados.getSelectedIndex());
            Asociado.listaAsociados.removeElement(indice);
            //cargarListaAsociado();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    private class gestorVerDatos implements MouseListener {

        private JCheckBox[] arrayCheckBox;
        Component[] componentesjPanelTipoAsociado;

        public gestorVerDatos() {
            arrayCheckBox = new JCheckBox[jPanelTipoAsociados.getComponentCount()];
            componentesjPanelTipoAsociado = new Component[jPanelTipoAsociados.getComponentCount()];
            componentesjPanelTipoAsociado = jPanelTipoAsociados.getComponents();
            for (int i = 0; i < componentesjPanelTipoAsociado.length; i++) {
                if (componentesjPanelTipoAsociado[i] instanceof JCheckBox) {
                    arrayCheckBox[i] = (JCheckBox) componentesjPanelTipoAsociado[i];
                }
            }
        }//Fin constructor que inicia el aray de nombres y el array de CheckBox

        public JCheckBox[] getArrayCheckBox() {
            return arrayCheckBox;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            jTextAreaMuestraAsociados.setEnabled(true);

            Asociado objAsociado;
            String textoMostrar = "";
            for (int i = 0; i < arrayCheckBox.length; i++) {

                if (jCheckBoxTodos.isSelected()) {
                    for (int j = 0; j < Asociado.listaAsociados.getSize(); j++) {
                        objAsociado = (Asociado) Asociado.listaAsociados.getElementAt(j);
                        if ((objAsociado.getClass().getSimpleName()).equals(arrayCheckBox[i].getName())) {
                            textoMostrar = textoMostrar + objAsociado.verDatos() + "\n" + objAsociado.email()
                                    + "\t" + objAsociado.verCuota()
                                    + "\n--------------------------------------------------------------------------\n";
                        }
                    }
                } else if (arrayCheckBox[i].isSelected()) {
                    for (int k = 0; k < Asociado.listaAsociados.getSize(); k++) {
                        objAsociado = (Asociado) Asociado.listaAsociados.getElementAt(k);
                        if ((objAsociado.getClass().getSimpleName()).equals(arrayCheckBox[i].getName())) {
                            textoMostrar = textoMostrar + objAsociado.verDatos() + "\n" + objAsociado.email()
                                    + "\t" + objAsociado.verCuota()
                                    + "\n--------------------------------------------------------------------------\n";
                        }
                    }
                }

                if (!"".equals(textoMostrar)) {
                    jTextAreaMuestraAsociados.setText(textoMostrar);
                }
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    private class gestorCheckBox implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JCheckBox desencadenadorEvento = (JCheckBox) e.getComponent();
            if (jCheckBoxTodos.getName().equals(desencadenadorEvento.getName())) {
                jCheckBoxProfesores.setSelected(false);
                jCheckBoxPersonalNoDocente.setSelected(false);
                jCheckBoxPadres.setSelected(false);
                jCheckBoxAlumnos.setSelected(false);
            } else {
                // jCheckBoxTodos.setSelected(false);
                jCheckBoxTodos.setSelected(jCheckBoxProfesores.isSelected() && jCheckBoxPersonalNoDocente.isSelected() && jCheckBoxPadres.isSelected() && jCheckBoxAlumnos.isSelected());
                if (jCheckBoxTodos.isSelected()) {
                    jCheckBoxProfesores.setSelected(false);
                    jCheckBoxPersonalNoDocente.setSelected(false);
                    jCheckBoxPadres.setSelected(false);
                    jCheckBoxAlumnos.setSelected(false);
                }
            }
            jButtonVerAsociados.setEnabled(jCheckBoxTodos.isSelected() || jCheckBoxProfesores.isSelected() || jCheckBoxPersonalNoDocente.isSelected() || jCheckBoxPadres.isSelected() || jCheckBoxAlumnos.isSelected());
            jTextAreaMuestraAsociados.setEnabled(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos">
    private void jListListaAsociadosValueChanged(ListSelectionEvent e) {
        if (jListListaAsociados.getSelectedIndex() != -1) {
            Asociado asociadoSeleccionado = (Asociado) Asociado.listaAsociados.getElementAt(jListListaAsociados.getSelectedIndex());
            jTextFieldTipoAsociado.setText(String.valueOf(asociadoSeleccionado.getClass().getSimpleName()));
            jTextFieldApellidoNombre.setText(asociadoSeleccionado.getApellidos() + " " + asociadoSeleccionado.getNombre());
            jTextFieldNIF.setText(asociadoSeleccionado.getNIF());
            jTextFieldCuota.setText(String.valueOf(asociadoSeleccionado.verCuota()));
        }

    }

    public void cargarListaAsociado() {
        jListListaAsociados.setModel(Asociado.listaAsociados);

    }

    public void CheckBoxVisibilidad() {
        gestorVerDatos gVD = new gestorVerDatos();
        for (int i = 0; i < gVD.getArrayCheckBox().length; i++) {
            if (!"Todos".equals(gVD.getArrayCheckBox()[i].getName())) {
                for (int j = 0; j < Asociado.listaAsociados.getSize(); j++) {
                    if (Asociado.listaAsociados.get(j).getClass().getSimpleName().equals(gVD.getArrayCheckBox()[i].getName())) {
                        jCheckBoxTodos.setVisible(true);
                        gVD.getArrayCheckBox()[i].setVisible(true);
                        break;
                    }
                }
            }
        }
    }

    public void iniciarMisComponentes() {
        //gestorVerDatos gestionVerDatos = new gestorVerDatos();
        jCheckBoxTodos.setName("Todos");
        jCheckBoxAlumnos.setName("Alumno");
        jCheckBoxPadres.setName("PadreMadre");
        jCheckBoxPersonalNoDocente.setName("PersonaNoDocente");
        jCheckBoxProfesores.setName("Profesor");
        jButtonEliminarAsociado.setEnabled(false);
        jButtonVerAsociados.setEnabled(false);
        jTextAreaMuestraAsociados.setText("Elige un empleado para ver sus datos.\nElige un tipo para ver los asociados");
        jListListaAsociados.addListSelectionListener(new gestorLista());
        jButtonEliminarAsociado.addMouseListener(new gestorEliminarEmpleado());
        jButtonVerAsociados.addMouseListener(new gestorVerDatos());
        // jCheckBoxTodos.addMouseListener(new gestorCheckBox());
        for (int i = 0; i < jPanelTipoAsociados.getComponentCount(); i++) {
            Component c = jPanelTipoAsociados.getComponent(i);
            if (c instanceof JCheckBox) {
                c.setVisible(false);
                c.addMouseListener(new gestorCheckBox());
            }
        }
        CheckBoxVisibilidad();
    }

    public void iniciarAsociados() {
        new PadreMadre("Silvia", "Diez Gonzalez", "12345678K");
        new PersonaNoDocente("SANTIAGO CESAR", "SANTOS BILINSKI", "1241385", "Mecanico");
        new PadreMadre("Gregorio", "Martirena Marton", "12345678K");
        new Alumno("Noemi", "Alonso Rodriguez", "2568987M", false, Alumno.Curso.BACH2);
        new PadreMadre("Julia", "Mateos Rosso", "68995632K");
        new PersonaNoDocente("GUMER", "FIGUEROA PEREZ", "1727741E", "Psicologa");
        new Profesor("CLAUDIO", "PIRIZ CAZULO", "1004410X", "Dibujo");
//        new Profesor("SERGIO ROMÁN", "MARTINEZ PINI", "3819952I", "Lengua");
        new Alumno("Ramiro", "Alvarez Ortiz", "2569822J", true, Alumno.Curso.FP2);
        new PersonaNoDocente("MABEL", "HUELMO HUELMO", "4217910S", "Parada");
        new Alumno("Luis", "Fredes Almiron", "29556636S", true, Alumno.Curso.ESO4);
        new Alumno("Carmelo", "Alpuy Casas", "3659823X", true, Alumno.Curso.ESO2);
//        new Profesor("GRACIELA MARIA", "PONGIBOVE PICERNO ", "3454292J", "informatica");
        new PadreMadre("Nelson", "Velazquez Silvera", "89632152K");
//        new Profesor("DANIEL", "MARTINEZ PLADA", "3983559L", "matematicas");
        new PersonaNoDocente("JOSE EDGARDO", "RUFFINI PEREZ", "3269524W", "Carpintero");

    }

    //</editor-fold>
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAsociado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListListaAsociados = new javax.swing.JList<>();
        jLabelTipoAsociado = new javax.swing.JLabel();
        jLabelApellidoNombre = new javax.swing.JLabel();
        jLabelNif = new javax.swing.JLabel();
        jLabelSalario = new javax.swing.JLabel();
        jTextFieldTipoAsociado = new javax.swing.JTextField();
        jTextFieldApellidoNombre = new javax.swing.JTextField();
        jTextFieldNIF = new javax.swing.JTextField();
        jTextFieldCuota = new javax.swing.JTextField();
        jButtonEliminarAsociado = new javax.swing.JButton();
        jPanelInformes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMuestraAsociados = new javax.swing.JTextArea();
        jPanelTipoAsociados = new javax.swing.JPanel();
        jCheckBoxTodos = new javax.swing.JCheckBox();
        jCheckBoxAlumnos = new javax.swing.JCheckBox();
        jCheckBoxProfesores = new javax.swing.JCheckBox();
        jCheckBoxPadres = new javax.swing.JCheckBox();
        jCheckBoxPersonalNoDocente = new javax.swing.JCheckBox();
        jButtonVerAsociados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelAsociado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asociado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Caslon Pro Bold", 1, 18))); // NOI18N

        jScrollPane1.setViewportView(jListListaAsociados);

        jLabelTipoAsociado.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelTipoAsociado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTipoAsociado.setText("Tipo Asociado:");
        jLabelTipoAsociado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabelApellidoNombre.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelApellidoNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelApellidoNombre.setText("Apellido y Nombres:");
        jLabelApellidoNombre.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabelNif.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelNif.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNif.setText("NIF:");
        jLabelNif.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabelSalario.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelSalario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSalario.setText("Cuota");
        jLabelSalario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jTextFieldTipoAsociado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldTipoAsociado.setEnabled(false);

        jTextFieldApellidoNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldApellidoNombre.setEnabled(false);

        jTextFieldNIF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNIF.setEnabled(false);

        jTextFieldCuota.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCuota.setEnabled(false);

        jButtonEliminarAsociado.setText("Eliminar Asociado");

        javax.swing.GroupLayout jPanelAsociadoLayout = new javax.swing.GroupLayout(jPanelAsociado);
        jPanelAsociado.setLayout(jPanelAsociadoLayout);
        jPanelAsociadoLayout.setHorizontalGroup(
            jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAsociadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(87, 87, 87)
                .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelApellidoNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipoAsociado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAsociadoLayout.createSequentialGroup()
                        .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCuota)
                            .addComponent(jTextFieldNIF)
                            .addComponent(jTextFieldTipoAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jButtonEliminarAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldApellidoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jPanelAsociadoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelApellidoNombre, jLabelNif, jLabelSalario, jLabelTipoAsociado});

        jPanelAsociadoLayout.setVerticalGroup(
            jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAsociadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAsociadoLayout.createSequentialGroup()
                        .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTipoAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTipoAsociado, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelApellidoNombre)
                            .addComponent(jTextFieldApellidoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNif)
                            .addComponent(jTextFieldNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAsociadoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelAsociadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelSalario)
                                    .addComponent(jTextFieldCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAsociadoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEliminarAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))))
                    .addGroup(jPanelAsociadoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanelAsociadoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelApellidoNombre, jLabelNif, jLabelSalario, jLabelTipoAsociado, jTextFieldApellidoNombre, jTextFieldCuota, jTextFieldNIF, jTextFieldTipoAsociado});

        jPanelInformes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Caslon Pro Bold", 1, 18))); // NOI18N

        jTextAreaMuestraAsociados.setColumns(20);
        jTextAreaMuestraAsociados.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMuestraAsociados);

        jPanelTipoAsociados.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de asociados a Mostrar"));

        jCheckBoxTodos.setText("Todos");

        jCheckBoxAlumnos.setText("Alumnos");

        jCheckBoxProfesores.setText("Profesores");

        jCheckBoxPadres.setText("Padres");

        jCheckBoxPersonalNoDocente.setText("Personal No Docente");

        javax.swing.GroupLayout jPanelTipoAsociadosLayout = new javax.swing.GroupLayout(jPanelTipoAsociados);
        jPanelTipoAsociados.setLayout(jPanelTipoAsociadosLayout);
        jPanelTipoAsociadosLayout.setHorizontalGroup(
            jPanelTipoAsociadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoAsociadosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelTipoAsociadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxPersonalNoDocente)
                    .addComponent(jCheckBoxPadres)
                    .addComponent(jCheckBoxTodos)
                    .addComponent(jCheckBoxAlumnos)
                    .addComponent(jCheckBoxProfesores))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanelTipoAsociadosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCheckBoxAlumnos, jCheckBoxPadres, jCheckBoxPersonalNoDocente, jCheckBoxProfesores, jCheckBoxTodos});

        jPanelTipoAsociadosLayout.setVerticalGroup(
            jPanelTipoAsociadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoAsociadosLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jCheckBoxTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                .addComponent(jCheckBoxAlumnos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                .addComponent(jCheckBoxProfesores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(jCheckBoxPadres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(jCheckBoxPersonalNoDocente)
                .addGap(9, 9, 9))
        );

        jPanelTipoAsociadosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCheckBoxPersonalNoDocente, jCheckBoxProfesores, jCheckBoxTodos});

        jButtonVerAsociados.setText("Ver Asociados");

        javax.swing.GroupLayout jPanelInformesLayout = new javax.swing.GroupLayout(jPanelInformes);
        jPanelInformes.setLayout(jPanelInformesLayout);
        jPanelInformesLayout.setHorizontalGroup(
            jPanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTipoAsociados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerAsociados, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanelInformesLayout.setVerticalGroup(
            jPanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformesLayout.createSequentialGroup()
                .addGroup(jPanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelInformesLayout.createSequentialGroup()
                        .addComponent(jPanelTipoAsociados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVerAsociados, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAsociado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAsociado, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameAsociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAsociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAsociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAsociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAsociados().setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Declaracion de variables">   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminarAsociado;
    private javax.swing.JButton jButtonVerAsociados;
    private javax.swing.JCheckBox jCheckBoxAlumnos;
    private javax.swing.JCheckBox jCheckBoxPadres;
    private javax.swing.JCheckBox jCheckBoxPersonalNoDocente;
    private javax.swing.JCheckBox jCheckBoxProfesores;
    private javax.swing.JCheckBox jCheckBoxTodos;
    private javax.swing.JLabel jLabelApellidoNombre;
    private javax.swing.JLabel jLabelNif;
    private javax.swing.JLabel jLabelSalario;
    private javax.swing.JLabel jLabelTipoAsociado;
    private javax.swing.JList<String> jListListaAsociados;
    private javax.swing.JPanel jPanelAsociado;
    private javax.swing.JPanel jPanelInformes;
    private javax.swing.JPanel jPanelTipoAsociados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaMuestraAsociados;
    private javax.swing.JTextField jTextFieldApellidoNombre;
    private javax.swing.JTextField jTextFieldCuota;
    private javax.swing.JTextField jTextFieldNIF;
    private javax.swing.JTextField jTextFieldTipoAsociado;
    // End of variables declaration//GEN-END:variables

// </editor-fold >
}
