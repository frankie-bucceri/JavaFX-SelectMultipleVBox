/* JavaFXListViewMultiple
JavaFX GUI multiple selections (hold control to select multiple before hitting get selections)
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.collections.ObservableList;

public class JavaFXListViewMultiple extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   } //end main
   
   public void start(Stage pStage)
   {
      // Constants for list view size
      final double WIDTH = 200, HEIGHT = 200;
      
      // Create a ListView of the names of months
      ListView<String> listView1 = new ListView<>();
      listView1.setPrefSize(WIDTH, HEIGHT);
      listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      listView1.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September",
         "October", "November", "December");
       
       //Create a lsitview to show the selections
      ListView<String> listView2 = new ListView<>();
      listView2.setPrefSize(WIDTH, HEIGHT);
       //create a button to get the selections
      Button getButton = new Button("Get Selections");
       // Register the event handler
      getButton.setOnAction(
         event ->
         {
            //get the observeable list of selected items
            ObservableList<String> selections = listView1.getSelectionModel().getSelectedItems();
           // Add them to the second list
            listView2.getItems().addAll(selections);
         });
          
        // add controls to a VBox
      VBox vbox = new VBox(10, listView1, listView2, getButton);
      vbox.setPadding(new Insets(10));
      vbox.setAlignment(Pos.CENTER);
        
      Scene scene = new Scene(vbox);
      pStage.setScene(scene);
      pStage.setTitle("ListView with Miltiple Selections");
      pStage.show();               
   } //end start()
} //end class