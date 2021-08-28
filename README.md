# GestionSoft

## Table of Contents
1. [Introduction](#Introduction)
2. [Software](#Software)
3. [Connection](#Connection)
4. [Starting screen](#Starting-screen)
5. [Login](#Login)
6. [Access block](#Access-block)
7. [Company Registration](#Company-Registration)
8. [Clean button](#Clean-button)
9. [Delete button](#Delete-button)
10. [Registration of the item](#roti)
11. [Add button: item](#abi)
12. [Product Registration](#Product-Registration)
13. [Add button: Products](#abp)
14. [Product inquiry](#Product-inquiry)
15. [Missing Button](#Missing-Button)
16. [Print button](#Print-button)
17. [High supplier](#High-supplier)
18. [Modify Provider](#Modify-Provider)
19. [Delete suppliers button](#dsb)
20. [Billing: Sale Counter](#bsc)
21. [Add button](#Add-button)
22. [Invoice button](#Invoice-button)
23. [Social networks](#Social-networks)
24. [About us](#About-us)


## 1.[Introduction](#Introduction)

Soft Management is a system designed by students of the Higher Technique in Software Development of the C&P Soft Institute.
The idea arose after a proposal by Professor María Emilia Cuello (Professor of the C&P Institute and Professor of the students), in order to present a sample of what the students learned during the 1st. It was gaining strength as new ideas arrived and were coordinated in order to achieve effective and efficient software when installing and running its actuators in the different labor fields.
With clear ideas of what they wanted for their program, these students divided their tasks and in small groups decided to approach and put their hands to work on said Software ...

## 2.Software

### Objectives?:
A first idea in total unanimity, was to create a system with the objective of registering sales of a business (a generic type business). In this case, the students chose as an example to record sales of a bookstore. This emerged in a dialogue with the need to help one of the members of the student body, that is, one of these students had a bookstore and lacked a system that could fully control their business. From there this first objective arose with the idea of ​​controlling its Stock, registering new clients and invoicing among others.

### Name?:
After realizing the idea about the objective of this software, the students began an endless debate of what they would call this program.
Among so many ideas contributed, one came in common for the "Great Majority" and it was to establish or face, by a name that was in accordance with the system and at the same time with its objective, that is how the name of Management was generated, alluding to to its meaning as a set of operations that are carried out to direct and manage a business or a company. But not satisfied and seeing the cloudiness that a simple and solitary "Management" proposed, the students decided to concatenate a second name in reference to the software they were creating and at the same time honoring the name of the institute in which they were studying C&P - Soft. This is how the name -Gestión Soft- was established as the name of the program, allowing students to advance with it.
In this way, demonstrating joint work, collaboration, enthusiasm, the infinite desire to learn, listen and contribute, these students got down to work together with the assistance and collaboration of the tutor teachers, to develop this Software step by step. with an excellent final review. (In later chapters we will be able to observe how it works and how it was created).

## 3.Connection

One of the first and most important steps to perform for the operation of this Software is to establish a connection to a database (a set of data belonging to the same context and systematically stored for later use). For this program the students decided to establish the connection with the Microsoft Access tool, a simple database, easy to understand when creating tables and making relationships between them (actions necessary for its operation). Next, the connection model can be seen in the image:

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240788732_5030528520347089_5877044068191670954_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=b9115d&_nc_ohc=8Vhtuxhs54QAX9DKhEK&_nc_ht=scontent.ftuc1-2.fna&oh=188d36d70825627ecd1a8e49f43633b0&oe=614EEB1A)

Before starting, you must download the Ucanaccess drivers that will allow us to connect the environment with our database, for this we can do so by going to the following link:
http://ucanaccess.sourceforge.net/site.html
once downloaded we must add these libraries to our project.
Steps to follow:
1) Within our project: we must create a class called Connection.
2) Within this class you must import the libraries and SQL classes, for this we must write the following lines:

importjava.sql* ; by writing the * before the; We declare that we want to import the entire sql package. Those that will allow us to make use of the Connection, Statement and ResultSet classes, necessary to establish the connection and actions within the program.

3) Within the class you must create 3 global variables of static type, the first of which, as we can see in the photo, is the variable that designates the connection class, therefore we must make use of it and create an object from it , in this case we call it with:

        static Connection con = null;
        
Then we declare 2 variables of type String to load the driver with which we can establish the connection (driver), and the other for the (url: Location of the Access BD on the computer):

    static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    static Stringurl = "jdbc:ucanaccess://C:Ubicación_BD";
    
4) Create a method of the Connection class of type static, in this case called GetConnection ().
5) Within this method, a Try_Catch block must be created in which we will work as follows:

        try {
          if (con == null) {
            Class.forName(driver);
            con=DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Conexión Correcta");
            }
          }catch (Exception e) {	
            e.printStackTrace();
            con=null;
            JOptionPane.showMessageDialog(null, "Error");
          }
          return con;
        }
        
        
        
In the try block we can observe inside a connection it is equal to null, we must execute the Class.forName (driver); driver as an attribute; this will allow us to load the aforementioned driver.
On the line with = DriverManager.getConnection (url); the connection is established through DriverManager by sending url (mentioned above) as an attribute.
In the catch block we use the Exception error and we re-establish the connection to null in case of error.
Finally, we return this connection to the method.

To finish we create a Main method that will allow us to test the connection, when executing it must send us a message of the Correct Connection:

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240808330_5030528463680428_2105631339110955004_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=b9115d&_nc_ohc=WQAfRblYV8sAX_V-g1T&_nc_ht=scontent.ftuc1-2.fna&oh=fef0e42ef6e6f6efe839a585d599bec3&oe=6150EBD1)

In this way, our Access database is fully connected with the eclipse development environment.

## 4.Starting screen

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240779387_5030528467013761_8707536519771171222_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=b9115d&_nc_ohc=0cBed2JTAF0AX_Z9HE_&_nc_ht=scontent.ftuc1-2.fna&oh=a8def64d35a29faa60a9cd2b12f69c81&oe=6150BFAD)

The home screen serves the function of welcoming the user or company to register.
It contains an encoding to not close by means of the cross that contains the window:

    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    
The screen consists of two buttons, Accept, Exit. The screen is represented by a background image that contains the name of the project that is related to a subclass called Background, it contains a JPanel.
The JPanel contains a text variable called "name". this will allow it to be related to the JFrame on the Start screen.

    public Fondo(String nombre) {
        Imagen=new ImageIcon(getClass().getResource(nombre));
        setSize(Imagen.getIconWidth(),Imagen.getIconHeight());
      }

Two libraries are imported into the JPanel: Dimension and Graphics
Dimension: allows the background image to fit the size of the window
Graphics: This object allows us to access the background of the JFrame and, using the graphical primitives, draw lines, rectangles, etc. In this case it will only contain the background image

    protectedvoidpaintComponent(Graphics g){
        Dimension d=getSize();
        g.drawImage(Imagen.getImage(),0,0,d.width,d.height,null);
        this.setOpaque(false);
        super.paintComponent(g);
      }

The Exit button fulfills a single function which is to close the window, that is, only this button will be able to close the window by means of an action with the following coding:

    btnSalir.addActionListener(new ActionListener() {
          public voidactionPerformed(ActionEvent arg0) {
            Inicio.this.dispose();}});

The Accept button is what the next window will not bring, which in this case will be the Logeo screen.

    btnAceptar.addActionListener(new ActionListener() {
          public voidactionPerformed(ActionEvent arg0) {
              Logeo l=new Logeo();
          l.setVisible(true);
            Inicio.this.dispose();					
          } });

## 5.Login

The User window fulfills the function of taking a User Name and its respective password already registered.

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/238658117_5030528380347103_8751053443952335864_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=b9115d&_nc_ohc=A88XovNeBhcAX8tdPJo&_nc_ht=scontent.ftuc1-2.fna&oh=5ba695b39f22e546c682e73a6fc255b3&oe=61507981)

The software has two default Admin and General accounts whose passwords are "1234" and "abcd" respectively. The Admin account has all the privileges such as:

● Add (User> Register new user)
● Delete accounts
● View their respective passwords (Users> User Control).

The General account has all of these restricted options, but you can:

● Change your password (User> Change password),
● Register items, suppliers, customers and Stock
● Register invoices.

## 6.Access block

If both the username and / or password are entered incorrectly 3 times, an error message will appear asking you to contact the Administrator. The user will not be able to enter until the error is corrected. This is accomplished in the following way, a variable of type integer (int) called error:

    error=error+1
    if(error==3) {
    JOptionPane.showMessageDialog(null, "Comuníquese con el administrador!","Error!!",JOptionPane.ERROR_MESSAGE);
    dispose();// cierra el jframe
    
A try / catch is used to verify the connection and if it connects successfully to the database, it looks for the users that are saved in it.
The try / catch allows you to find faults in the program. The code inside try will execute the program process and in case an error occurs or fails for some reason, the catch catches said error in the Exception ex variable and skips a JOption indicating that failure.
The query is used to perform a query or extract data from a database. In this case, we perform a query on the User Names and Passwords saved in the database to check if they match the data entered in the User window.

    query = "select * from Usuario whereNom_U = '"+user+"' and Clave_U = '"+clave+"'";
        try [
                                 con = Conexion.obtenerconexion();
          st = con.createStatement();
          rs = st.executeQuery(query);
          while (rs.next()) {
            if (rs.getString(1)==null) {
              sw = 0;
            } else {
              sw = 1;
            }
                                     }

        }catch (Exception ex){
          JOptionPane.showMessageDialog(null, "Error sql"+ ex);
        }


## 7.Company Registration

Company registration is an InternalFrame that allows us to register a company in order to carry out its management.

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240798833_5030528747013733_1406895204268858874_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=b9115d&_nc_ohc=H0Ez3b-Mh5sAX_OnPLn&tn=ICuuEgcaK7k8X9f1&_nc_ht=scontent.ftuc1-1.fna&oh=370fa1a623c1351789e9650575822bd1&oe=614E4310)

The window has the title of Company Registration, three buttons (Register, Clean and Delete), it also contains the fields in which a record will be inserted in each field according to what is requested to save it in the Access table called Company , all of this can be done by connecting to the table. For this you need to import into the Connection class, importjava.sql.Connection; and then declare it Connection with = null; With the following button called Register it can be added to the table by assigning it an action, publicvoidactionPerformed (ActionEvent arg0) {, within a block of "try-cantch" the query for the database must be performed using a text variable " Stringsql "

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240813237_5030528757013732_7239922285384313604_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=b9115d&_nc_ohc=7ZiquddnMZUAX8nbxP8&tn=ICuuEgcaK7k8X9f1&_nc_ht=scontent.ftuc1-1.fna&oh=582f78b56d1e6f18c3634f1880ef23fd&oe=614E05C8)

    Stringsql= "insertinto Empresa (Nombre_Empresa, CUIT, Categoria_IVA, Direccion_Empresa, Telefono_Empresa, Sucursal_Emp) values (?,?,?,?,?,?)";
    
insertinto Empresa: inserts the record in the "Empresa" table.

The values that take the signs "?", Is where the records will be stored in order according to the fields in the query.
The connection to the table is created with = Connection.getconnection (); , we will also put an object that will hold the sql text variable.

PreparedStatementpst = con.prepareStatement (sql); , and then establish the code lines according to the query made. The rest of the coding will remain:

    pst.setString(1, textNombre.getText());
    pst.setString(2, textCuit.getText());
    pst.setString(3, textCat.getText());
    pst.setString(4, textDireccion.getText());
    pst.setString(5, textTelefono.getText());
    pst.setString(6, textSucursal.getText());
    int n = pst.executeUpdate();
    
 Within the same try-cantch block, a confirmation message is displayed, that is, a message that confirms that the records were inserted into the database.

    JOptionPane.showMessageDialog(rootPane, "Se registró de forma correcta!"); }
    }catch(Exception ex){
      ex.printStackTrace();
            }try-catch

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240788098_5030528780347063_798811834019642387_n.jpg?_nc_cat=111&ccb=1-5&_nc_sid=b9115d&_nc_ohc=HryWFyas8BAAX9FjErC&_nc_ht=scontent.ftuc1-2.fna&oh=b0fbab798cbdac6e32446eac94a48f8e&oe=614F0541)

To view the records recently added to the database, in the Company Registration window you need to create a JTable, a text variable is created to save the table titles:

    Stringtitulos []={"Id" , "Nombre de Empresa" , "CUIT" , "Categoria IVA" , "Direccion", "Telefono", "Sucursal"};
    Luego crear el JTable:
    tblEmp =new JTable();
    tblEmp.setBackground(new Color(102, 204, 153));
    tblEmp.setFont(new Font("MS Reference Sans Serif", Font.BOLD,11));
    
Once the table is created, it is necessary to show the records in it, for this a method with the name "show" is created.
Inside a try-catch block, the connection will be called and a vector containing [7] objects, in this case, the titles, is declared.

    public voidmostrar(){
      try{
      con =Conexion.obtenerconexion();
    DefaultTableModeldtmTitulos = new DefaultTableModel(null, titulos);
      Stringdts []=new String [7];
      Stringsql="select * from Empresa";
      Statementst=con.createStatement();
      ResultSetrs=st.executeQuery(sql);
      while(rs.next()){
        dts[0]=rs.getString("Id_Emp");
        dts[1]=rs.getString("Nombre_Empresa");
        dts[2]=rs.getString("CUIT");
        dts[3]=rs.getString("Categoria_IVA");
        dts[4]=rs.getString("Direccion_Empresa");
        dts[5]=rs.getString("Telefono_Empresa");
        dts[6]=rs.getString("Sucursal_Emp");

        dtmTitulos.addRow(dts);
          }
      tblEmp.setModel(dtmTitulos);
      tblEmp.getColumnModel().getColumn(0).setMaxWidth(0);
      tblEmp.getColumnModel().getColumn(0).setMinWidth(0);
      tblEmp.getColumnModel().getColumn(0).setPreferredWidth(0);

        } catch(Exception ex){
        ex.printStackTrace();
         con=null;
          }
      }

As can be seen in the coding, the following codes with setMaxWidth (0), setMinWidth (0) and setPreferredWidth (0), allow the Id of the Access database table to not be displayed in the JTable. In this way we will only put the "show" method in the encoding of the register, mostrar (); button.

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240781785_5030528943680380_8628243696885497595_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=b9115d&_nc_ohc=9PL4Ssj3w_wAX8T5f1Z&_nc_ht=scontent.ftuc1-2.fna&oh=7ca7f9a50688c6127b772be75ac3a47b&oe=614FA97A)

## 8.Clean button

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240810501_5030528950347046_4641958157812797015_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=b9115d&_nc_ohc=0wQE7p9FmHAAX_1dUpB&_nc_ht=scontent.ftuc1-2.fna&oh=97b5050da19c4083b1371840ecc56f99&oe=614D5F53)

The function it fulfills is simple since it only clears the fields, enabling them to insert a new record.

    protectedvoidbtnEditarActionPerformed(ActionEventevt) {
      textField.setText("");
      textNombre.setText("");
      textCuit.setText("");
      textCat.setText("");
      textDireccion.setText("");
      textTelefono.setText("");
      textSucursal.setText("");
      }

The same coding that contains the button action is also included in the Register button, so that after inserting a record, the fields are automatically cleared.

## 9.Delete button

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/238280413_5030528967013711_7255136622548371920_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=b9115d&_nc_ohc=5NBESQi2kEkAX_qX0nU&_nc_ht=scontent.ftuc1-1.fna&oh=7d6af89f636beed8101403dce0587bc3&oe=614E8E91)

This button fulfills the function of deleting the records from both the database and the JTable.
Through an action that contains a try-catch block.
Within this action, the user is warned if he really wants to delete the records by means of a message.

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240757366_5030528420347099_339108950443325770_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=b9115d&_nc_ohc=040Q4_PQJ2gAX_3THWD&tn=ICuuEgcaK7k8X9f1&_nc_ht=scontent.ftuc1-1.fna&oh=e6bc26de5282fa511c51795e35a04f79&oe=614F160A)


    protectedvoidbtnEliminarActionPerformed(ActionEventevt) {
      inteli=tblEmp.getSelectedRow();
      if(eli>=0) { 
      intresp=JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el registro?",
          null, JOptionPane.YES_NO_OPTION, pesp);

The yes or no options are made up of a decision maker, since for “yes” the record will be eliminated, but the opposite that is “no” the record will not be eliminated.
Calling the connection, the show method and to clean the fields (in case the record is deleted) the encoding within a try-catch block, the encoding will be as follows:

    if (JOptionPane.OK_OPTION==resp){
      try {
        Connection con = null;
           con = Conexion.obtenerconexion();
      Stringsql = "deletefrom Empresa whereId_Emp= ?";
      PreparedStatementpst = con.prepareStatement(sql);
      pst.setInt(1, Integer.parseInt(textField.getText()));
      int n = pst.executeUpdate();
      if (n >0){
      JOptionPane.showMessageDialog(rootPane, "Datos eliminados correctamente!");

      mostrar();
        textField.setText("");
        textNombre.setText("");
        textCuit.setText("");
        textCat.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        textSucursal.setText("");
          }
       } catch (SQLExceptionex){
      JOptionPane.showMessageDialog(rootPane, "Datos no eliminados de forma correcta!"+ ex.getMessage());
    }
    

## 10.Registration of the item

When registering an item, enter the name of the item in the field.
When an item is entered, the program assigns it a unique code for each one, which increases from one thousand to one thousand.

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240818931_5030528510347090_142940227024228105_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=b9115d&_nc_ohc=Hlgs3l05UhcAX-yfBFc&_nc_ht=scontent.ftuc1-2.fna&oh=2f3456b2602e3f74c211d82fd66f9661&oe=6150D28B)

To save an item, the following libraries must be imported.

    importjava.sql.Connection;
    importjava.sql.PreparedStatement;

we proceed to create the following variable "con" globally in this way it will allow it to be used throughout the project:

    connection con=null;

two variables of type integer P and num are also declared. A num will start with the value of 1000.

## 11.Add button: item

A repetitive cycle must be declared, in this case the FOR (cycle for) is used, which allows you to go through the table and find out what is the code that was found in that route. It is stored in a variable to the code to be able to increase it.
In order to increase the code that is stored in the variable P, it must be converted to an integer since it is stored in the table as text (String).
Below, you can see part of the coding:


    for(int i=0;i<table.getRowCount();i++){
                p=Integer.parseInt((String) table.getValueAt(i, 1))   
                }

Within the for loop, a decision making is created, which will serve to increase the code.

    for(int i=0;i<table.getRowCount();i++){
    p=Integer.parseInt((String) table.getValueAt(i, 1));

    if(p>num|| p==num){
          num=num+1000;}}

A "try-catch" block is set; since the procedures and / or lines of code to be executed could produce exceptions and / or errors.
Inside it we will create an object of the connection class. It is created from the connection class to pass sql statements to the database.

    try {
          con = Conexion.obtenerconexion();



      }catch (Exception ex) {
          JOptionPane.showMessageDialog(rootPane, "Error al agregar");	}

A variable of the type “String” is created and it will be called “sql”, in this variable the sentence “sql” is defined that will allow the insertion of data in a table. In this example the table in question is "Item".

In the final part of the sentence you can see a series of closing question marks, you must establish the same number of signs according to the number of fields in the table in which you want to save data; that is, if you have placed 2 fields in the table, you must set 2 signs (?).

    Stringsql = "insertinto Rubros (Cod_Rubro,Nom_Rubro) values (?,?)";

The "sql" statement to be sent and executed must be prepared and / or compiled to save the records in the database. An object of type preparedStatement is created, and it will be called “pst”. Then we proceed to call the object "with" to which the preparedStatement () method will be applied. A parameter must be passed to this method, which in this case consists of the variable that contains the “sql” statement; Because it is possible that when you work with a database there are "sql" statements that you have to execute several times during a session, such as when you want to insert several records in a table, the databases have a mechanism so that in these cases the execution of those repeated sentences is faster. The data you enter will be different but the SQL statement will be the same because it will be previously indicated which statement to use in each case, so that it is saved in a condition to be executed immediately without the need to analyze it.

		PreparedStatementpst = con.prepareStatement(sql);
    
The preparedStatementpst object will be used, and then the setString () method will be called, to which 2 parameters will be passed, the first will be an integer value; 1 that will identify the position of one of the values (VALUES) in our sql statement; the second parameter will refer to the variable that will contain the value you want to assign to it.

    pst.setString(1, (String.valueOf(num)));
    pst.setString(2, textField.getText());

Finally, taking into account the preparedStatementpst object, the executeUpdate () method will be applied to it; This will allow to send and execute in the database, the sql statement that has been created, but with the values assigned to it in the previous step. That is, with this the data storage process is already being carried out in the Rubro table.

    pst.setString(1, (String.valueOf(num)));
    pst.setString(2, textField.getText());
    pst.executeUpdate(); 

## 12.Product Registration

To register a product, the first thing we must do is select the item of the product that we are going to load, one of the codes loaded previously must be selected from the JComboBox, for this the JComboBox must perform a search in the database and take only the codes to show it in said combo, for this we carry out a method called public voidcombo ()

    public voidcombo(){
      this.comboCodigo.removeAllItems();
    this.comboCodigo.addItem("SELECCIONAR CÓDIGO");
    try{
    ResultSet rs1 = null;
    Conexion conect3 = new Conexion();
              con = conect3.obtenerconexion();
    StatementSent = con.createStatement();
              rs1 = Sent.executeQuery("select * from Rubros");
    while(rs1.next()){
    this.comboCodigo.addItem(rs1.getString("Cod_Rubro"));
              }
              contador++;
    }catch (SQLException e){
          }
    }

Once the combo has loaded the data from the database, the next thing is to put an action on it, which allows that when selecting a code it shows in a JLabel what item it is about and saves the code that we just entered in a hidden JTextField select to be used later when loading data.

    protectedvoid combo1ActionPerformed(ActionEventevt) {
        try{
          if(this.contador>0){
    ResultSet rs = null;
    Connection con2 = null;
    Conexion conect2 = new Conexion();
                    con2 = conect2.obtenerconexion();
    StatementSent = con2.createStatement();
    ResultSet rs1 = Sent.executeQuery("select * from Rubros whereCod_Rubro= '" + this.comboCodigo.getSelectedItem().toString() + "'");
                    rs1.next();

    this.lblArticulo.setText(String.valueOf(rs1.getString("Nom_Rubro")));
    this.textField_1.setText(String.valueOf(rs1.getString("Id_Rubro")));
              }

    }catch(SQLException e){

    JOptionPane.showMessageDialog(null, e);
            }
      }

## 13.Add button: Products

The first thing to do is assign an action to the button (ActionPerformed), within this action we carry out the following coding where we declare 2 variables of type Int operation and p, the variable operation saves the code that we select in the combo and in turn adds + 1, we use a for to go through the entire table and the variable p saves the value of column 0 which is the code column, a second for is used that goes through the table again and we perform an if condition where we compare if the variable p is less than / equal to operation, the operation variable is increased +1 and saved, otherwise (else) the operation variable is decreased -1 and saved.

    operacion=Integer.parseInt((String)comboCodigo.getSelectedItem().toString());
    operacion = operacion+1;
    for(int i=0;i<tblProducto.getRowCount();i++){
    p=Integer.parseInt((String) tblProducto.getValueAt(i, 0));
    for(int i1=operacion;i1==p;i1=operacion+1) {
      if(p<operacion||p==operacion){
      operacion=p+1;
      }else {
      operacion=p-1;}}}
    for(int i=0; i<tblProducto.getRowCount();i++) {
    a=Integer.parseInt((String)tblProducto.getValueAt(i, 1));
      if(a==operacion) {
      operacion=a+1;
        }
      }

Once the code to add is obtained, we proceed to connect the database indicating the corresponding fields that we want to add, these must be written in the same way as they are in our database. Then we must call the connection method with its library and declare the Statement so that the corresponding sql type statement is executed and thus declare all the data to be added one by one.

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240776083_5030528537013754_3426145304187995348_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=b9115d&_nc_ohc=3pql4tUpRdcAX9LKI3E&_nc_ht=scontent.ftuc1-2.fna&oh=34f578e03f324b649aa7aff5a899c41e&oe=614E58EF)

## 14.Product inquiry

To perform the product query we use a grid, which is loaded with the database records, and a JTextField to filter the grid records.
We must import the TableRowSorter class that allows us to sort and filter the rows of a JTable:

    public static TableRowSorter trs;

    Al JTextField se le debe dar un evento (KeyTyped) y dentro crear un public voidkeyReleased(KeyEvent e) {

    trs.setRowFilter(RowFilter.regexFilter("(¿¡)"+textField.getText(), 0));                }

In this example we will use a regex filter, that is, the data passes the filter if it meets a certain pattern, in our case it will pass the filter when writing any letter either uppercase or lowercase. To get said RowFilter, we use the RowFilter.regexFilter () method.
As the first parameter, a regular expression (regex) is passed that the data must meet to pass the filter. In our case it is a simple String with a "(¿!)" Inside.
An integer is passed as the second parameter to identify the column to which the filter is to be applied. The first column is zero. In our case, we will do it on the first column, so we will pass a 0.
This will cause that when writing in the JTextField all the rows will be hidden and only those that contain the letters that we are writing will be filtered.

    @Override
          public voidkeyTyped(KeyEvent arg0) {
            textField.addKeyListener(new KeyAdapter() {

              @SuppressWarnings("unchecked")
              @Override
              public voidkeyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+textField.getText(), 0));
        }});


![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240795132_5030528527013755_6148997807741604947_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=b9115d&_nc_ohc=WrgIKIowiPsAX9qaVJA&_nc_ht=scontent.ftuc1-2.fna&oh=3479ba3949150965e2385b3d1535074f&oe=61505B63)

## 15.Missing Button

Pressing the missing button opens a JFrame where it shows the products with a stock> = 5, this serves to keep track of the products that we must renew their stock.

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240777711_5030528787013729_8018440732396530986_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=b9115d&_nc_ohc=3US_FUZ1jDsAX8lqGvR&_nc_ht=scontent.ftuc1-1.fna&oh=04135857f225504e2463cd2fdb07914b&oe=614FE26C)

## 16.Print button 

In any sales system it is important to control the quantity of products that are in stock. This program facilitates the task of supervising and controlling low-stock products, not allowing product shortages, since the program also makes it possible for the list of missing products to be printed to pass it on to suppliers.
The output by the printer is composed of a header, the table in the body of the sheet and in the footer, the page number.

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240788192_5030528817013726_498356803427000397_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=b9115d&_nc_ohc=k0v-Pp7lfrAAX_UjOAo&tn=ICuuEgcaK7k8X9f1&_nc_ht=scontent.ftuc1-1.fna&oh=2854e3a2a74fef6abf84721c7e0033a5&oe=614FD7F0)


You must import the MessageFormat class, which allows you to print a header on the page.
In the action of the print button, an object of the MessageFormat class is created and within the parameter, the header text.

    MessageFormatheader=new MessageFormat("Productos con bajo stock:");

In the next step, a "try-catch" block is set; and within it the JTableprint () method will be used. Inside the parameter you pass the print format and the object created from the MessageFormat class, which is the header of the page.

      MessageFormatheader=new MessageFormat("Productos con bajo stock:");
      MessageFormatfooter=new MessageFormat("Pagina{0,number,integer}");
            try{
          faltantes.print(JTable.PrintMode.FIT_WIDTH,  header, footer);
            }catch(java.awt.print.PrinterException e){
            System.err.format("Error de impresion ", e.getMessage());
              }

## 17.High supplier
The first step is within our jFrame to add various text fields so that when entering the data we require, these are saved in their corresponding location within the database. We should also add some jLabels in the form of the title of each text so that the user understands what data to enter in the fields.
Add button:
From the design window, we will double click to go to the command line that gives the button actions, as seen below:

    JButtonbtnAñadir = new JButton("Añadir");
        btnAñadir.addActionListener(new ActionListener() {
          public voidactionPerformed(ActionEvent arg0) {

Within the automatically generated public void, we proceed to declare variables that will be the fields that have to be filled in to enter a provider,

    String Nombre_prov,Direccion_prov,Localidad_prov,Email_prov,TipoProd_prov, Telefono;
    
Subsequently we proceed to give the value to these variables of the data entered in the text fields, this is done in the following way: first entering the name of the variable followed by an equal sign and finally the name of the text with a “.getText (); " In the end.

    Nombre_prov=  textNombreProv.getText();
    
This process is carried out with all the variables created recently with their corresponding text.
Then a try catch must be generated in order to load everything entered into our database. The try catch is used since it ensures that the program continues to function in case a task fails; if the code inside the try fails, the catch is executed. Inside try we will call the query method as follows:

    con = conection.obtenerconexion();
    
In this case "connection" is the name of the class generated to establish connection with access and "getconnection" is the name of the method within the connection class.
Next, a variable of type String is declared with the name sql and it will have the value of

    InsertintoProveedores(Nombre_prov,Direccion_prov,Localidad_prov,Email_prov,Telefono_prov,TipoProd_prov)”+"Values('"+Nombre_prov+"','"+Direccion_prov+"','"+Localidad_prov+"','"+Email_prov+"','"+Telefono+"','"+TipoProd_prov+"')";
    

The Insertinto and Values commands are specific to the database. Insertinto will be used to insert into the generated columns and they must have the exact same name as the one in the database. Values for its part, will give the value to the fields of the columns.
 Now the createStatement method of the connection class will be used and all columns and values will be updated. Optionally, a message will be displayed on the screen indicating that the provider has been added and a message asking if we want to add another provider.
 
     JOptionPane.showMessageDialog(null, "Proveedor Añadido");
     
 Then the catch part will be used to display a message indicating the name of the error in case the process has failed.
 
     catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "No Se Cargaron Los Registros. "+ex);}

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240816023_5030528853680389_8248454890361499854_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=b9115d&_nc_ohc=-wxZmKk8XMcAX9vxnqv&_nc_ht=scontent.ftuc1-1.fna&oh=2b1287309d2b439375bd2936f21ff3a5&oe=61506E51)

## 18.Modify Provider

To modify it is necessary to first add an action to the MouseClicked table, for this, in the desing window, right click on the table properties and go to the section “addeventhandler / Mouse / Mouse clicked. As seen below:

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240786876_5030528637013744_5105461117913809890_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=b9115d&_nc_ohc=36e_pjWTOQQAX8OSOgk&_nc_ht=scontent.ftuc1-1.fna&oh=cbdf233c7ce34a99084a305ced4bcc58&oe=6151133F)

By doing this we are redirected to the source tab where we will give a task to the mouse clicked action. There we will create a variable of numeric type named Rows and value table.getSelectedRow (); What will make the table that we clicked is selected

    public voidmouseClicked(MouseEvent arg0) {
            int Filas = table.getSelectedRow();
            
 Now we start an if that compares if our Row variable is greater than or equal to zero, if it is, we will make our text fields take the value of the selected table, for this we must put the name of the text, followed by a period and setText and finally in parentheses we assign the value of the selected table. All this is as follows
 
     textId.setText(table.getValueAt(Filas, 0).toString());	
     nombre.setText(table.getValueAt(Filas, 1).toString());

The else is now used to issue an error message in case the row selection fails.

    else {
    JOptionPane.showMessageDialog(null, "¡Seleccione una Fila!");

Once the coding is done, a data update is required when we press the modify button, using the connection class and try catch, as already seen in the Add button.

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240813214_5030529013680373_2442930167311418993_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=b9115d&_nc_ohc=ozapmdp-iTYAX9jtTLC&_nc_ht=scontent.ftuc1-1.fna&oh=14da6663b9a8a32192de683cee3f7bcf&oe=614FAAAD)

## 19.Delete suppliers button

This button also requires a try catch where we are going to use the get connection method of the connection class. A String variable with sql name and value "DeleteFrom Providers whereCod_Prov =?" Will be declared;
In this case, the selected provider is eliminated according to its code, since this is unique and will never be repeated, thus avoiding errors such as eliminating more than one provider.
This is done to simplify the command in question and thus make the program more verbose.
Then the code preparedStatament "Prepared Declaration" will be used

	PreparedStatementps = con.prepareStatement(sql);.

Now we will use the created method, "ps", and convert its stored data to one of type int to extract the value of our text id

	ps.setInt(1, Integer.parseInt(textid.getText()));
  
An update is then run along with a message to indicate that the task was successful

    int n = ps.executeUpdate();	
    if(n>0) {	JOptionPane.showMessageDialog(null, "Proveedor Eliminado!");
      Consulta("");
      
      
Finally, the catch will be used to display an error message

    catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "•roveedor No Eliminado! "+ex);}

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240821574_5030528543680420_5940116023653018523_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=b9115d&_nc_ohc=s6UnmESLVWIAX_SN7aM&_nc_ht=scontent.ftuc1-2.fna&oh=338e3ff074d16017d8119ba99f282bd4&oe=6150D7DF)

## 20.Billing: Sale Counter

This screen consists of the division into three parts,
● Clients with the Search Clients Button.
● Products with the Search Products Button.
● Sale with the Invoice Button.

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240802234_5030529060347035_2510501050670930557_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=b9115d&_nc_ohc=X8CvCLrGhCEAX8QpPng&_nc_ht=scontent.ftuc1-2.fna&oh=a531e46cff3a2cc5aa1f74939da62b62&oe=614F2D75)

To search for products and customers, the connection must be declared and established, which connects to the database and shows the records loaded in the grid, here we have the tableMouseOnClicked event, its function is to select a record and replace them in the text fields for this data to be sent, this search also has a Send button, where it will transport the selected data to the corresponding fields on the Sale screen. To achieve this, the import of the library must be implemented.
import.java.awt.event.MouseEvent;

## 21.Add button

It indicates the action of loading the products in the grid, performing arithmetic mathematical calculations to calculate the total amount of the products that one carries. To perform this calculation, String type and Double type variables must be defined, they are defined this way because the JTextFields only comprise texts and must be converted to numbers so that the corresponding calculations can be carried out.

    Cantidad=textField_1.getText(); //Obtención de datos de tipo texto
    CANTIDAD=Double.parseDouble(Cantidad); //Conversión a números para cálculos
    TOTAL=PRECIO*CANTIDAD;
    Total=TOTAL.toString()+“0”;
    
## 22.Invoice button

It must be connected to the database indicating the corresponding fields that we want to record that correspond to our table where we will store the data and we pass the parameters to it so that they are recorded. Here we must call the connection method with its library, declaration of the Statement so that the corresponding sql type statement is executed.

    Stringsql = “Insertinto Factura (Fecha_Factura, Total_Factura) values( ?, ?) ”;
    con=Conexión.obtenerConexion();
    PreparedStatementpst = prepareStatement(sql);

## 23.Social networks

This JFrame is oriented to the application and implementation of a code fragment, which will allow us to open a web page from a Java application, this fragment will be placed inside a method. This procedure becomes very important when, for example, we want to direct our clients to our website, from the program that we have just developed.
What we do in this code snippet is basically create a "try-catch" block. Inside the "try", what we will do is use the "Desktop" Class, and therefore the ".getDesktop ()" method; which leads us to execute and obtain an instance of a native desktop application that allows handling a URI (UniformResourceIdentifier) ​​or a file; that is, we can launch applications such as browsers, email clients, and specific programs that allow us to open, edit or print files. Next we use the ".browse ()" method to launch the default browser of our system. We pass a parameter to this method, which in this case is an instance of the Class "URI"; that is, "new URI ()", and the parameter that we pass will be a String, which will contain the url of the web page that you want to open.

![Image text](https://scontent.ftuc1-1.fna.fbcdn.net/v/t1.6435-9/240804592_5030529070347034_3525619368014589815_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=b9115d&_nc_ohc=TaJTkHVDPacAX-3cQ-Q&_nc_ht=scontent.ftuc1-1.fna&oh=093cba8db77364fd54b31bc53ee35164&oe=614EAEB6)

    public voidactionPerformed(ActionEvent arg0) {
    if(java.awt.Desktop.isDesktopSupported()){
    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
    if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
      try {
    java.net.URIuri=new java.net.URI("https://www.facebook.com");
    desktop.browse(uri);
      } catch (URISyntaxException | IOException ex) {}}}}});

# 24.About us

This JFrame has a brief information on who the GestionSoft developers are, the names of each one and a photo presenting them.

![Image text](https://scontent.ftuc1-2.fna.fbcdn.net/v/t1.6435-9/240801394_5030528557013752_6028406646243565189_n.jpg?_nc_cat=111&ccb=1-5&_nc_sid=b9115d&_nc_ohc=aZGxdwFJKbUAX-j34vH&tn=ICuuEgcaK7k8X9f1&_nc_ht=scontent.ftuc1-2.fna&oh=92eb6f2a0a0e203025b1c56e4b503e25&oe=6150D90E)
