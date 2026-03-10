package finalthing;

//import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.Arrays;
import javax.swing.JOptionPane;
//import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class editorg extends javax.swing.JFrame {

    /**
     * Creates new form editorg
     */
    public editorg() {
        JOptionPane.showMessageDialog(rootPane, "No file to load specified", "guh...", HEIGHT);
        hoem h = new hoem();
        h.setVisible(true);
        this.setVisible(false);
    }
    
    public editorg(String file) {
        try {
            //the goal of this block is to convert any given file format into one standard, which will drastically simplify the programming later
            
            String contents = "";
            String line;
            int i = 0;

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                //collecting every line and converting into a single line in a variable
                if(i == 0){
                    contents = line;
                }
                else{
                    contents = contents+"¬¬"+line;
                }
                
                i++;
                
            }   
            br.close();
            fr.close();
            
            //replacing commas in a CSV with my format
            contents = contents.replace(",", "``");
            
            
            //this block is converting the single line thingy into a 2D array, to be added to the JTable
            
            //split the line around the "rows"
            String[] split1 = contents.split("¬¬");
            //System.out.println(Arrays.toString(split1));
            //now get the first line only to find the number of columns
            String temps = split1[0];
            int j = 0;
            for(int p=0; p < temps.length()-1; p++){
                if(temps.substring(p,p+1).equals("`")){
                    j++;
                }
            }
            j = j / 2;
            // System.out.println(j);
            
            //this array never has anything actually inserted in it but it is needed to make the table behave
            //its length = number of columns in the table
            //with no items inside the titles default to alphabetical which is extremely convenient for me
            String[] heads;
            
            //2D arrays confuse me
            //each item is a row, and each subitem is part of its respective column
            String[][] contents2;
            if(j < 55){
                j = 55;
            }
            if(i < 55){
                i = 55;
            }
            contents2 = new String[i][j+1];
            heads = new String[j+1];
            String[] split2;
            int k = 0;
            
            while(k < split1.length){
                //same operation as temps, but this time grabbing every row
                split2 = split1[k].split("``");
                //System.out.println(Arrays.toString(split2));
                //inserting each item into the 2D array
                //this makes no sense and i hate it, but it works
                for(int n = 0; (n < split2.length) && (n < contents2[k].length-1); n++){
                    //System.out.println(n);
                    //System.out.println(contents2[k].length);
                    contents2[k][n+1] = split2[n];
                    //System.out.println(Arrays.deepToString(contents2));
                }
                contents2[k][0] = String.valueOf(k+1);
                //System.out.println(Arrays.deepToString(contents2));
                k++;
            }
            
            
            initComponents();
            //TableModel - basically just a 2D array with an additional 1D array for headers
            TableModel model = new DefaultTableModel(contents2, heads);
            //JTable spread = new JTable(model);
            //configuring the spreadsheet
            spread.setModel(model);
            spread.setFont(new java.awt.Font("Lucida Console", 0, 12));
            //the size must correspond to the amount of cells or it won't scroll correctly
            spread.setPreferredSize(new java.awt.Dimension(80*(j+1), 24*(i+1)));
            spread.setMaximumSize(new java.awt.Dimension(80*(j+1), 24*(i+1)));
            spread.setMinimumSize(new java.awt.Dimension(80*(j+1), 24*(i+1)));
            spread.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            spread.setCellSelectionEnabled(true);
            spread.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            spread.setShowGrid(true);
            spread.setRowHeight(24);
            spread.setRowSelectionAllowed(false);
            //tell the scroll pane to actually display the sheet
            jScrollPane2.setViewportView(spread);
            
            label.setText(file);
            
            
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "Specified file not found", "guh...", HEIGHT);
            hoem h = new hoem();
            h.setVisible(true);
            this.setVisible(false);
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Failed to open file", "guh...", HEIGHT);
            hoem h = new hoem();
            h.setVisible(true);
            this.setVisible(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BHome = new javax.swing.JButton();
        BSave = new javax.swing.JButton();
        BSave2 = new javax.swing.JButton();
        BConv = new javax.swing.JButton();
        BGraph = new javax.swing.JButton();
        BSort = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        spread = new javax.swing.JTable();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TableMaster - Editor");
        setPreferredSize(new java.awt.Dimension(1920, 1035));

        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1035));

        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 120));

        BHome.setBackground(new java.awt.Color(0, 32, 96));
        BHome.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        BHome.setForeground(new java.awt.Color(255, 255, 255));
        BHome.setText("Home");
        BHome.setMaximumSize(new java.awt.Dimension(80, 120));
        BHome.setMinimumSize(new java.awt.Dimension(80, 120));
        BHome.setPreferredSize(new java.awt.Dimension(80, 120));
        BHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHomeActionPerformed(evt);
            }
        });

        BSave.setBackground(new java.awt.Color(0, 32, 96));
        BSave.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        BSave.setForeground(new java.awt.Color(255, 255, 255));
        BSave.setText("Save");
        BSave.setPreferredSize(new java.awt.Dimension(80, 120));
        BSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSaveActionPerformed(evt);
            }
        });

        BSave2.setBackground(new java.awt.Color(0, 32, 96));
        BSave2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        BSave2.setForeground(new java.awt.Color(255, 255, 255));
        BSave2.setText("Save \nas");
        BSave2.setHideActionText(true);
        BSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSave2ActionPerformed(evt);
            }
        });

        BConv.setBackground(new java.awt.Color(0, 32, 96));
        BConv.setFont(new java.awt.Font("Bahnschrift", 0, 10)); // NOI18N
        BConv.setForeground(new java.awt.Color(255, 255, 255));
        BConv.setText("Plain Text");
        BConv.setPreferredSize(new java.awt.Dimension(80, 23));
        BConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConvActionPerformed(evt);
            }
        });

        BGraph.setBackground(new java.awt.Color(0, 32, 96));
        BGraph.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        BGraph.setForeground(new java.awt.Color(255, 255, 255));
        BGraph.setText("Graph");
        BGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGraphActionPerformed(evt);
            }
        });

        BSort.setBackground(new java.awt.Color(0, 32, 96));
        BSort.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        BSort.setForeground(new java.awt.Color(255, 255, 255));
        BSort.setText("Sort");
        BSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BConv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BSort, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1410, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BSave2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BConv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BSort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(1920, 120));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        spread.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(spread);

        label.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1989, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHomeActionPerformed
        hoem h = new hoem();
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BHomeActionPerformed

    private void BSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSaveActionPerformed
        try {
            TableModel conts = spread.getModel();
            //take the file's path straight from the UI
            //it is not just for user convenience
            FileWriter fw = new FileWriter(label.getText());
            BufferedWriter bw = new BufferedWriter(fw);
            
            //loop through to grab every cell and write to file
            for(int i=0; i<conts.getRowCount(); i++){
                for(int j=1; j<conts.getColumnCount()-1; j++){
                    if(conts.getValueAt(i, j) == null){
                        bw.write(",");
                    }
                    else{
                        bw.write(conts.getValueAt(i, j).toString()+",");
                    }
                }
                bw.write("\n");
            }   
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(rootPane, "File saved successfully", "hi", HEIGHT);
        } 
        //catch in case the file can't be found for whatever reason
        catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error while saving file", "hi", HEIGHT);
        }
    }//GEN-LAST:event_BSaveActionPerformed

    private void BSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSave2ActionPerformed
        //get the file's current path for autofill in the dialogs
        String cur = label.getText();
        //split the filepath around \ (four have to be typed to get around regex shenanigans
        String[] split = cur.split("\\\\");
        String path = "";
        //get rid of the file itself in the path, again for autofill
        path = cur.replace(split[split.length-1], "");
        
        String f = JOptionPane.showInputDialog("Please enter full path of the destination folder\n(blank to save within program)", path);
        String g = JOptionPane.showInputDialog("Please enter name and file extension of file", split[split.length-1]);
        
        //backup names because null is evil
        if(f == null){
            f = "";
        }
        if(g == null){
            g = "Untitled";
        }
        
        try {
            TableModel conts = spread.getModel();
            FileWriter fw = new FileWriter(f+g);
            BufferedWriter bw = new BufferedWriter(fw);
            
            //loop through to grab every cell and write to file
            for(int i=0; i<conts.getRowCount(); i++){
                for(int j=1; j<conts.getColumnCount()-1; j++){
                    if(conts.getValueAt(i, j) == null){
                        bw.write(",");
                    }
                    else{
                        bw.write(conts.getValueAt(i, j).toString()+",");
                    }
                }
                bw.write("\n");
            }   
            bw.close();
            fw.close();
            //show the new name/path in the editor
            label.setText(f+g);
            
            JOptionPane.showMessageDialog(rootPane, "File saved successfully", "hi", HEIGHT);
        } 
        //catch in case the file can't be found for whatever reason
        catch (IOException ex) {
            //Logger.getLogger(editorg.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Error while saving file", "hi", HEIGHT);
        }
    }//GEN-LAST:event_BSave2ActionPerformed

    private void BConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConvActionPerformed
        //if(BConv.getText().equals("Sheet view")){
            //System.out.println("hi");
            TableModel conts = spread.getModel();
            String[][] newv = new String[1][1];
            for(int i=0; i<conts.getRowCount(); i++){
                for(int j=1; j<conts.getColumnCount()-1; j++){
                    if(conts.getValueAt(i, j) == null){
                        newv[0][0] = newv[0][0] + ",";
                    }
                    else{
                        newv[0][0] = newv[0][0] + (conts.getValueAt(i, j).toString()+",");
                        //bw.write(conts.getValueAt(i, j).toString()+",");
                    }
                }
                newv[0][0] = newv[0][0] + "\n";
                //System.out.println(Arrays.deepToString(newv));
                //bw.write("\n");
            }
            JTextArea box = new javax.swing.JTextArea(newv[0][0]);
            box.setFont(new java.awt.Font("Lucida Console", 0, 12));
            
            //jPanel1.remove(spread);
            jScrollPane2.setViewportView(box);
            
            //jPanel1.revalidate();
            //jPanel1.repaint();
            
            
            //BConv.setText("Text view");
        //}
        //else{
            //Get the components in the panel
            //Component[] componentList = jScrollPane2.getComponents();

            //Loop through the components
            //for(Component c : componentList){

                //Find the component
                //if(c instanceof JTextArea){
                    
                //}
            //}
        //}
    }//GEN-LAST:event_BConvActionPerformed

    private void BGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGraphActionPerformed
        //get the selected things
        int[] rows = spread.getSelectedRows();
        int[] cols = spread.getSelectedColumns();
        //make sure they arent trying to make a graph out of nothing
        if(rows.length < 1 || cols.length < 1){
            JOptionPane.showMessageDialog(rootPane, "Select some cells to create a graph", "Could not complete operation", HEIGHT);
        }
        else{
            //now we need to make a 2D array with all the selected values
            String[][] values = new String[rows.length][cols.length];

            //loop through and grab every cell which corresponds to one within the selected area
            TableModel conts = spread.getModel();
            for(int i=0; i < rows.length; i++){
                    for(int j=0; j < cols.length; j++){
                        //screen out any null values as they would ruin my day
                        if(conts.getValueAt(rows[i], cols[j]) == null){
                            values[i][j] = "";
                        }
                        else{
                            values[i][j] = conts.getValueAt(rows[i], cols[j]).toString();
                        }
                    }
                }
            
            //now that the 2D array is assembled it can be passed to the graph window for further calculation
            graph g = new graph(values);
            g.setVisible(true);
        }
    }//GEN-LAST:event_BGraphActionPerformed

    private void BSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSortActionPerformed
        utils u = new utils();
        
        int col = spread.getSelectedColumn();
        TableModel conts = spread.getModel();
        String[][] arrconts = new String[conts.getRowCount()][conts.getColumnCount()];
        //convert the tablemodel into a 2D array for calculations
        //loop through to grab every cell and write to array
            for(int i=0; i<conts.getRowCount(); i++){
                for(int j=1; j<conts.getColumnCount()-1; j++){
                    if(conts.getValueAt(i, j) == null){
                        arrconts[i][j] = "";
                    }
                    else{
                        arrconts[i][j] = conts.getValueAt(i, j).toString();
                    }
                }
                arrconts[i][0] = Integer.toString(i+1);
            }   
        
        //insertion sort
        //variables:
        //current - the item being compared
        //j - iterator for the while loop
        String[] current;
        int j = 0;

        //for loop that loops through the unsorted list, right to left
        //IMPORTANT: i is set to 1 instead of 0
        for(int i = 1; i<arrconts.length; i++){
            //set current to, well, the current item
            current = arrconts[i];
            //set j to the current index
            j=i;

            //while you haven't reached the end of the list AND the next item is bigger than the current item
            //tryInt method from utils class - converts a string to a Double, or 0 if conversion is impossible
            while (j > 0 && u.tryInt(arrconts[j-1][col])>u.tryInt(current[col])){
                //set the new current item to the next item
                arrconts[j] = arrconts[j - 1] ;
                //subtract 1 from j (reads right to left)
                j--;
            }
            //whatever item caused the while loop to end, set that to the old current
            arrconts[j] = current;
        }
        
        //converting back to a tablemodel is mercifully simple
        String[] heads = new String[arrconts[0].length];
        TableModel model = new DefaultTableModel(arrconts, heads);
        //configuring the spreadsheet
        spread.setModel(model);
    }//GEN-LAST:event_BSortActionPerformed

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
            java.util.logging.Logger.getLogger(editorg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editorg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editorg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editorg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editorg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BConv;
    private javax.swing.JButton BGraph;
    private javax.swing.JButton BHome;
    private javax.swing.JButton BSave;
    private javax.swing.JButton BSave2;
    private javax.swing.JButton BSort;
    private java.awt.Canvas canvas1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JTable spread;
    // End of variables declaration//GEN-END:variables
}
