package com.example.hblpsl;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class TeamDetails {

    private static final String TEAM_FILE = "Teams.txt";
    private static final String PLAYER_IN_TEAM_FILE = "PlayersInTeams.txt";
    private List<Player> playerList = new ArrayList<>();
    private static final String MATCH_FILE = "Match.txt";
    VBox playerBox = new VBox(10);


    public Scene createTeamDetailsScene(Stage stage, Scene scene, String text) {

        Label teamLabel = new Label("Welcome to " + text +  " Details!");
        teamLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: blue; -fx-font-weight: bold; -fx-text-fill: green;");

        Button back = new Button("Back");
        back.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(227,233,191);");
        back.setMinHeight(30);
        back.setMinWidth(80);
        back.setOnAction(e -> {
            TeamsDesign teamsDesign = new TeamsDesign();
            Stage currentStage = (Stage) back.getScene().getWindow();
            Scene scene1 = new Scene(new StackPane(),1000,800);
            currentStage.setTitle("Teams of PSL...!!!");
            currentStage.setScene(teamsDesign.createTeamScene(currentStage,scene1));
        });

        Button backButton = new Button("Back to Main");
          backButton.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(227,233,191);");
        backButton.setMinHeight(30);
        backButton.setMinWidth(110);
        backButton.setOnAction(e -> {
            try {
                Menu menu = new Menu();
                Scene menuScene = new Scene(new StackPane(), 1000, 800);
                Stage currentStage = (Stage) backButton.getScene().getWindow();
                currentStage.setTitle("Menu Page of PSL...!!!");
                currentStage.setScene(menu.start(currentStage, menuScene));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        });

        HBox hBox = new HBox(10);
        BorderPane.setMargin(hBox, new Insets(10,0,0,10));
        hBox.getChildren().addAll(back,backButton);

        Button teamOverview = new Button("Team Overview");
        teamOverview.setStyle("-fx-min-height: 100px; -fx-min-width: 200px; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-radius: 20px; -fx-background-color: rgb(227,233,191)");
        Button teamPlayers =new Button("Players");
        teamPlayers.setStyle("-fx-min-height: 100px; -fx-min-width: 200px; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-radius: 20px; -fx-background-color: rgb(227,233,191)");

        HBox twoButtonBox = new HBox(20);
        twoButtonBox.getChildren().addAll(teamOverview,teamPlayers);


        Button teamMatches = new Button("Team Matches");
        teamMatches.setStyle("-fx-min-height: 100px; -fx-min-width: 200px; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-radius: 20px; -fx-background-color: rgb(227,233,191)");
        teamMatches.setOnAction(e -> {
            TeamStats teamStats1 = new TeamStats();
            Stage currentStage = (Stage) teamMatches.getScene().getWindow();
            Scene scene1 = new Scene(new StackPane(), 1000, 800);
            currentStage.setTitle("Team Matches...!!!");
            currentStage.setScene(teamStats1.teamMatchesScene(currentStage,scene1,text));
        });
        

        Button teamStats = new Button("Team Stats");
        teamStats.setStyle("-fx-min-height: 100px; -fx-min-width: 200px; -fx-font-size: 18px; -fx-font-weight: bold; -fx-background-radius: 20px; -fx-background-color: rgb(227,233,191)");
        teamStats.setOnAction(e -> {
            TeamStats teamStats1 = new TeamStats();
            Stage currentStage = (Stage) teamStats.getScene().getWindow();
            Scene scene1 = new Scene(new StackPane(), 1000, 800);
            currentStage.setTitle("Team Stats...!!!");
            currentStage.setScene(teamStats1.teamStatsScene(currentStage,scene1,text));
        });

        HBox twoButtonBox2 = new HBox(30);
        twoButtonBox2.getChildren().addAll(teamMatches,teamStats);

        teamOverview.setOnAction(e -> {
            try {
                Stage currentStage = (Stage) teamOverview.getScene().getWindow();
                Scene scene1 = new Scene(new StackPane(), 1000, 800);
                currentStage.setTitle("Team Overview...!!!");
                currentStage.setScene(teamOverviewScene(currentStage,scene1,text));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        teamPlayers.setOnAction(e -> {
            try {
                Stage currentStage = (Stage) teamPlayers.getScene().getWindow();
                Scene scene1 = new Scene(new StackPane(), 1000, 800);
                currentStage.setTitle("Team " + text + " Players...!!!");
                currentStage.setScene(teamPlayersScene(currentStage, scene1, text));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        VBox vBox = new VBox(40);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMaxHeight(400);   vBox.setMaxWidth(400);
        vBox.setMaxHeight(400);   vBox.setMinWidth(400);

        vBox.getChildren().addAll(teamLabel,twoButtonBox,twoButtonBox2);

        BackgroundFill backgroundFill1 = new BackgroundFill(Color.rgb(204,204,153),null,null);
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(backgroundFill1));
        borderPane.setTop(hBox);
        borderPane.setCenter(vBox);
        BorderPane.setAlignment(vBox, Pos.CENTER);
        BorderPane.setAlignment(hBox, Pos.TOP_LEFT);

        return new Scene(borderPane,1000,800);
    }




    public Scene teamOverviewScene(Stage stage, Scene scene, String text) {
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER);
       // vBox1.setStyle("-fx-background-color: rgb(227,233,191");
        vBox1.setMaxHeight(400);
        vBox1.setMaxWidth(400);

        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: rgb(255,253,208); -fx-min-width: 400px; -fx-min-height: 350px; -fx-font-size: 17px; -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 2px;");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(TEAM_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] overviewList = line.split(",");
                if (overviewList[0].equals(text)) {
                    String[] firstSevenParts = new String[Math.min(7,overviewList.length)];
                    System.arraycopy(overviewList, 0, firstSevenParts, 0, firstSevenParts.length);
                    Label overViewTeam = new Label("!!!--- Team OverView ---!!!");
                    overViewTeam.setAlignment(Pos.CENTER);
                    overViewTeam.setStyle("-fx-background-color: rgb(255,253,208);-fx-min-width: 400px; -fx-min-height: 100px; -fx-text-fill: green; -fx-font-size: 18px; -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 2px;");
                    Label nameLabel = new Label("Team Name:  ");              Label nameValue = new Label(overviewList[0]);
                    Label captainLabel = new Label("Team Captain:  ");        Label captainLabelValue = new Label(overviewList[1]);
                    Label headCoachLabel = new Label("Head Coach:  ");        Label headCoachValue = new Label(overviewList[2]);
                    Label battingCoachLabel = new Label("Batting Coach:  ");  Label battingCoachValue = new Label(overviewList[3]);
                    Label bowlingCoachLabel = new Label("Bowling Coach:  ");  Label bowlingCoachValue = new Label(overviewList[4]);
                    Label ownerLabel = new Label("Team Owner:  ");            Label ownerValue = new Label(overviewList[5]);
                    Label teamCity = new Label("Home City:  ");               Label teamCityValue = new Label(overviewList[6]);


                    HBox nameBox = new HBox();             nameBox.getChildren().addAll(nameLabel,nameValue);                           nameBox.setAlignment(Pos.CENTER);
                    HBox captainBox = new HBox();          captainBox.getChildren().addAll(captainLabel,captainLabelValue);             captainBox.setAlignment(Pos.CENTER);
                    HBox headCoachBox = new HBox();        headCoachBox.getChildren().addAll(headCoachLabel,headCoachValue);            headCoachBox.setAlignment(Pos.CENTER);
                    HBox battingCoachBox = new HBox();     battingCoachBox.getChildren().addAll(battingCoachLabel,battingCoachValue);   battingCoachBox.setAlignment(Pos.CENTER);
                    HBox bowlingCoachBox = new HBox();     bowlingCoachBox.getChildren().addAll(bowlingCoachLabel,bowlingCoachValue);   bowlingCoachBox.setAlignment(Pos.CENTER);
                    HBox ownerBox = new HBox();            ownerBox.getChildren().addAll(ownerLabel,ownerValue);                        ownerBox.setAlignment(Pos.CENTER);
                    HBox teamCityBox = new HBox();         teamCityBox.getChildren().addAll(teamCity,teamCityValue);                    teamCityBox.setAlignment(Pos.CENTER);

                    vBox.getChildren().addAll(nameBox,captainBox,headCoachBox,battingCoachBox,bowlingCoachBox,ownerBox,teamCityBox);
                    vBox1.getChildren().addAll(overViewTeam,vBox);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button backButton = new Button("back");
        backButton.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(255,253,208);");
        backButton.setMinHeight(30);
        backButton.setMinWidth(80);
        backButton.setOnAction(e -> {
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            Scene scene1 = new Scene(new StackPane(),1000,800);
            currentStage.setTitle("Teams " + text +"...!!!");
            currentStage.setScene(createTeamDetailsScene(currentStage,scene1,text));
        });

        Button homeButton = new Button("Back to Main");
        homeButton.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(255,253,208);");
        homeButton.setMinHeight(30);
        homeButton.setMinWidth(110);
        homeButton.setOnAction(e -> {
            try {
                Menu menu = new Menu();
                Scene menuScene = new Scene(new StackPane(), 1000, 800);
                Stage currentStage = (Stage) homeButton.getScene().getWindow();
                currentStage.setTitle("Menu Page of PSL...!!!");
                currentStage.setScene(menu.start(currentStage, menuScene));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        });
        HBox hBox = new HBox(10);
        BorderPane.setMargin(hBox, new Insets(10,0,0,10));
        hBox.getChildren().addAll(backButton,homeButton);

        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(227,233,191),null,null);

        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(backgroundFill));
        borderPane.setTop(hBox);
        borderPane.setCenter(vBox1);
        BorderPane.setAlignment(hBox, Pos.TOP_LEFT);

        return new Scene(borderPane,1000,800);
    }



    public Scene teamPlayersScene(Stage stage, Scene scene, String text) {

        Button removePlayer = new Button("Delete Player");
        removePlayer.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(255,253,208);");
        removePlayer.setMinHeight(35);
        removePlayer.setMinWidth(130);

        Button addPlayerManually = new Button("Add Player");
        addPlayerManually.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(255,253,208);");
        addPlayerManually.setMinHeight(35);
        addPlayerManually.setMinWidth(130);


        playersOfSpecificTeam(text);


        removePlayer.setOnAction(e -> {
            try {
                Stage currentStage = (Stage) removePlayer.getScene().getWindow();
                Scene scene1 = new Scene(new StackPane(), 1000, 800);
                currentStage.setTitle("Delete Player From " + text + "...!!!");
                currentStage.setScene(deletePlayerFromTeam(currentStage, scene1, text));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });



        addPlayerManually.setOnAction(e -> {
                Stage currentStage = (Stage) addPlayerManually.getScene().getWindow();
                Scene scene1 = new Scene(new StackPane(), 1000,800);
                currentStage.setTitle("Add Player " + text + " Team");
                currentStage.setScene(addPlayerInTeamManually(currentStage,scene1,text));
        });


        Button backButton = new Button("Back");
        backButton.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(255,253,208);");
        backButton.setMinHeight(30);
        backButton.setMinWidth(80);
        backButton.setOnAction(e -> {
            try {
                Scene menuScene = new Scene(new StackPane(), 1000, 800);
                Stage currentStage = (Stage) backButton.getScene().getWindow();
                currentStage.setTitle("Team " + text + "...!!!");
                currentStage.setScene(createTeamDetailsScene(currentStage, menuScene, text));
            }catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Button homeButton = new Button("Back to Main");
        homeButton.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(255,253,208);");
        homeButton.setMinHeight(30);
        homeButton.setMinWidth(110);
        homeButton.setOnAction(e -> {
            try {
                Menu menu = new Menu();
                Scene menuScene = new Scene(new StackPane(), 1000, 800);
                Stage currentStage = (Stage) homeButton.getScene().getWindow();
                currentStage.setTitle("Menu Page of PSL...!!!");
                currentStage.setScene(menu.start(currentStage, menuScene));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        });

        HBox hBox1 = new HBox(10);   hBox1.setAlignment(Pos.CENTER_LEFT);    hBox1.getChildren().addAll(backButton,homeButton,addPlayerManually,removePlayer);
        HBox imageBox = new HBox(10);  imageBox.setAlignment(Pos.CENTER);    imageBox.getChildren().addAll(playerBox);

        VBox vBox = new VBox(50);
        vBox.setStyle("-fx-background-color: rgb(215,223,163);");
        VBox.setMargin(hBox1, new Insets(10,0,0,10));
        vBox.getChildren().addAll(hBox1,imageBox);

        return new Scene(vBox, 1000,800);
    }


    public void playersOfSpecificTeam(String text) {
        playerBox.getChildren().clear();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20); // Horizontal gap between images
        gridPane.setVgap(20); // Vertical gap between rows
        gridPane.setAlignment(Pos.CENTER);

        try{
            BufferedReader reader = new BufferedReader(new FileReader(PLAYER_IN_TEAM_FILE));
            String line;
            int index = 0;
            while((line = reader.readLine()) != null) {
                String[] players = line.split(",");
                if(players[5].equals(text)){
                    String imagePath = players[0];
                    String playerDetails = line;
                    String playerName = players[2];
                    String text1 = text;
                    Image playerImage = new Image(getClass().getResource(imagePath).toExternalForm());
                    ImageView playerImageView = new ImageView(playerImage);
                    playerImageView.setFitWidth(180);
                    playerImageView.setFitHeight(180);


                    Circle clip = new Circle(80);
                    clip.setCenterX(80);
                    clip.setCenterY(80);
                    playerImageView.setClip(clip);

                    int row = index / 4;
                    int col = index % 4;

                    gridPane.add(playerImageView,col,row);
                    index++;

                    playerImageView.setOnMouseClicked(e -> {
                        Stage currentStage = (Stage) playerImageView.getScene().getWindow();
                        Scene scene = new Scene(new StackPane(), 1000, 800);
                        currentStage.setTitle(playerName + " details...!!!");
                        currentStage.setScene(showPlayerDetails(currentStage,scene,playerDetails,text1));
                    });

                    //playerBox.getChildren().add(gridPane);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        playerBox.getChildren().add(gridPane);
    }




    public Scene showPlayerDetails(Stage stage, Scene scene, String playerDetails,String text1) {


        String[] details = playerDetails.split(",");
        String imagePath = details[0];
        String id = details[1];     String name = details[2];    int age = Integer.parseInt(details[3]);
        String nationality = details[4];  String team = details[5];   String role = details[6];
        int jersey = Integer.parseInt(details[7]);   int totalRuns = Integer.parseInt(details[8]);
        int highScore = Integer.parseInt(details[9]);   int fifty = Integer.parseInt(details[10]);
        int century = Integer.parseInt(details[11]);

        Label label = new Label(name + " record...!!!");
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-background-color: rgb(255,253,208);-fx-min-width: 400px; -fx-min-height: 100px; -fx-text-fill: green; -fx-font-size: 18px; -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 2px;");


        Label playerID = new Label("ID:  ");     Label playerIDValue = new Label(id);
        Label nameLabel = new Label("Name:  ");       Label nameValue = new Label(name);
        Label ageLabel = new Label("Age:  ");         Label ageValue = new Label(details[3]);
        Label countryLabel = new Label("Country:  ");       Label countryValue = new Label(nationality);
        Label teamLabel = new Label("Team:  ");        Label teamValue = new Label(team);
        Label roleLabel = new Label("Role:  ");       Label roleValue = new Label(role);
        Label jerseyLabel = new Label("Jersey no:  ");     Label jerseyValue = new Label(details[7]);
        Label runs = new Label("Total Runs:  ");        Label runsValue = new Label(details[8]);
        Label highRuns = new Label("High Score:  ");     Label highRunsValue = new Label(details[9]);
        Label fiftyLabel = new Label("Fifties:  ");       Label fiftyValue = new Label(details[10]);
        Label centuryLabel = new Label("Centuries:   ");      Label centuryValue = new Label(details[11]);


        HBox hBox1 = new HBox(87);    hBox1.getChildren().addAll(playerID,playerIDValue);   hBox1.setPadding(new Insets(0,0,0,110));   // hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(60);    hBox2.getChildren().addAll(nameLabel,nameValue);    hBox2.setPadding(new Insets(0,0,0,110));    // hBox2.setAlignment(Pos.CENTER);
        HBox hBox3 = new HBox(80);    hBox3.getChildren().addAll(ageLabel,ageValue);      hBox3.setPadding(new Insets(0,0,0,110));     //hBox3.setAlignment(Pos.CENTER);
        HBox hBox4 = new HBox(47);    hBox4.getChildren().addAll(countryLabel,countryValue);   hBox4.setPadding(new Insets(0,0,0,110));  //hBox4.setAlignment(Pos.CENTER);
        HBox hBox5 = new HBox(65);    hBox5.getChildren().addAll(teamLabel,teamValue);          hBox5.setPadding(new Insets(0,0,0,110));  //hBox5.setAlignment(Pos.CENTER);
        HBox hBox6 = new HBox(72);     hBox6.getChildren().addAll(roleLabel,roleValue);        hBox6.setPadding(new Insets(0,0,0,110)); //hBox6.setAlignment(Pos.CENTER);
        HBox hBox7 = new HBox(32);     hBox7.getChildren().addAll(jerseyLabel,jerseyValue);        hBox7.setPadding(new Insets(0,0,0,110)); //hBox7.setAlignment(Pos.CENTER);
        HBox hBox8 = new HBox(20);      hBox8.getChildren().addAll(runs,runsValue);               hBox8.setPadding(new Insets(0,0,0,110)); //hBox8.setAlignment(Pos.CENTER);
        HBox hBox9 = new HBox(20);      hBox9.getChildren().addAll(highRuns,highRunsValue);       hBox9.setPadding(new Insets(0,0,0,110)); //hBox9.setAlignment(Pos.CENTER);
        HBox hBox10 = new HBox(62);     hBox10.getChildren().addAll(fiftyLabel,fiftyValue);        hBox10.setPadding(new Insets(0,0,0,110)); //hBox10.setAlignment(Pos.CENTER);
        HBox hBox11 = new HBox(32);      hBox11.getChildren().addAll(centuryLabel,centuryValue);        hBox11.setPadding(new Insets(0,0,0,110)); //hBox11.setAlignment(Pos.CENTER);


        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox1,hBox2,hBox3,hBox4,hBox5,hBox6,hBox7,hBox8,hBox9,hBox10,hBox11);
        vBox.setMaxHeight(500);     vBox.setMaxWidth(400);
        vBox.setMinHeight(500);      vBox.setMinWidth(400);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: rgb(255,253,208); -fx-font-size: 17px; -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 2px;");

        Image image = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);   imageView.setFitWidth(400);
        Circle clip = new Circle(200, 200, 200);
        imageView.setClip(clip);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(label,vBox);
        vBox1.setMaxHeight(600);     vBox1.setMaxWidth(400);
        vBox1.setMinHeight(600);      vBox1.setMinWidth(400);
        vBox1.setPadding(new Insets(0,50,0,50));
        vBox1.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(50);    hBox.getChildren().addAll(imageView,vBox1); hBox.setAlignment(Pos.CENTER);

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(255,253,208);");
        backButton.setMinHeight(30);
        backButton.setMinWidth(80);
        backButton.setOnAction(e -> {
            try {
                Scene menuScene = new Scene(new StackPane(), 1000, 800);
                Stage currentStage = (Stage) backButton.getScene().getWindow();
                currentStage.setTitle("Team " + text1 + " Players...!!!");
                currentStage.setScene(teamPlayersScene(currentStage, menuScene,text1));
            }catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        Button homeButton = new Button("Back to Main");
        homeButton.setStyle("-fx-font-size: 13px; -fx-font-weight: bold; -fx-background-radius: 15px; -fx-background-color: rgb(255,253,208);");
        homeButton.setMinHeight(30);
        homeButton.setMinWidth(110);
        homeButton.setOnAction(e -> {
            try {
                Menu menu = new Menu();
                Scene menuScene = new Scene(new StackPane(), 1000, 800);
                Stage currentStage = (Stage) homeButton.getScene().getWindow();
                currentStage.setTitle("Menu Page of PSL...!!!");
                currentStage.setScene(menu.start(currentStage, menuScene));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        });

        HBox backBox = new HBox(20);
        backBox.setAlignment(Pos.CENTER);
        backBox.getChildren().addAll(backButton,homeButton);

        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(227,233,191),null,null);
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(backgroundFill));
        borderPane.setTop(backBox);
        BorderPane.setAlignment(backBox,Pos.TOP_LEFT);
        BorderPane.setMargin(backBox,new Insets(10,0,0,10));
        borderPane.setCenter(hBox);
       BorderPane.setAlignment(hBox,Pos.CENTER);

        return new Scene(borderPane,1000,800);

    }





    public Scene addPlayerInTeamManually(Stage stage, Scene scene, String text) {

        int players = readPlayersFromFile(text);
        VBox vBox1 = new VBox();

        if (players < 11) {
            Label label1 = new Label("Name:  ");
            label1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField1 = new TextField();
            textField1.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox1 = new HBox(75);
            hBox1.setAlignment(Pos.CENTER_LEFT);
            hBox1.setPadding(new Insets(0,0,0,100));
            hBox1.getChildren().addAll(label1, textField1);

            Label label2 = new Label("Nationality:  ");
            label2.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField2 = new TextField();
            textField2.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox2 = new HBox(30);
            hBox2.setAlignment(Pos.CENTER_LEFT);
            hBox2.setPadding(new Insets(0,0,0,100));
            hBox2.getChildren().addAll(label2, textField2);

            Label label3 = new Label("Role:  ");
            label3.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            ComboBox<String> roleBox = new ComboBox<>();
            roleBox.getItems().addAll("Batsman", "Bowler", "All Rounder");
            roleBox.setPromptText("Select your Role");
            roleBox.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox3 = new HBox(88);
            hBox3.setAlignment(Pos.CENTER_LEFT);
            hBox3.setPadding(new Insets(0,0,0,100));
            hBox3.getChildren().addAll(label3, roleBox);

            Label label4 = new Label("Age:  ");
            label4.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField4 = new TextField();
            textField4.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox4 = new HBox(93);
            hBox4.setAlignment(Pos.CENTER_LEFT);
            hBox4.setPadding(new Insets(0,0,0,100));
            hBox4.getChildren().addAll(label4, textField4);

            Label label5 = new Label("Jersey No:  ");
            label5.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField5 = new TextField();
            textField5.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox5 = new HBox(45);
            hBox5.setAlignment(Pos.CENTER_LEFT);
            hBox5.setPadding(new Insets(0,0,0,100));
            hBox5.getChildren().addAll(label5, textField5);

            Label label6 = new Label("Total Runs:  ");
            label6.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField6 = new TextField();
            textField6.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox6 = new HBox(40);
            hBox6.setAlignment(Pos.CENTER_LEFT);
            hBox6.setPadding(new Insets(0,0,0,100));
            hBox6.getChildren().addAll(label6, textField6);

            Label label7 = new Label("Highest runs:  ");
            label7.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField7 = new TextField();
            textField7.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox7 = new HBox(25);
            hBox7.setAlignment(Pos.CENTER_LEFT);
            hBox7.setPadding(new Insets(0,0,0,100));
            hBox7.getChildren().addAll(label7, textField7);

            Label label8 = new Label("Half Century:  ");
            label8.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField8 = new TextField();
            textField8.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox8 = new HBox(25);
            hBox8.setAlignment(Pos.CENTER_LEFT);
            hBox8.setPadding(new Insets(0,0,0,100));
            hBox8.getChildren().addAll(label8, textField8);

            Label label9 = new Label("Century:  ");
            label9.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField9 = new TextField();
            textField9.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox9 = new HBox(66);
            hBox9.setAlignment(Pos.CENTER_LEFT);
            hBox9.setPadding(new Insets(0,0,0,100));
            hBox9.getChildren().addAll(label9, textField9);

            Label label10 = new Label("Image Path:  ");
            label10.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField textField10 = new TextField();
            textField10.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
            HBox hBox10 = new HBox(36);
            hBox10.setAlignment(Pos.CENTER_LEFT);
            hBox10.setPadding(new Insets(0,0,0,100));
            hBox10.getChildren().addAll(label10, textField10);

            Button addPlayer = new Button("Add");
            addPlayer.setPrefHeight(20);
            addPlayer.setPrefWidth(100);
            addPlayer.setStyle("-fx-text-fill: white; -fx-background-color: green; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 25px;");
            addPlayer.setOnAction(e -> {
                try {
                    String playerImagePath = textField10.getText();
                    String playerName = textField1.getText();
                    String playerNationality = textField2.getText();
                    String playerRole = roleBox.getValue();
                    int playerAge = Integer.parseInt(textField4.getText());
                    int playerJersey = Integer.parseInt(textField5.getText());
                    int playerRunsTotal = Integer.parseInt(textField6.getText());
                    int playerHighRuns = Integer.parseInt(textField7.getText());
                    int playerFifty = Integer.parseInt(textField8.getText());
                    int playerCentury = Integer.parseInt(textField9.getText());

                    Player newPlayer = new Player(playerName, playerNationality, text, playerRole, playerAge, playerJersey, playerRunsTotal, playerHighRuns, playerFifty, playerCentury,playerImagePath);
                    playerList.add(newPlayer);
                    savePlayersToFile(newPlayer);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Player added successfully!");
                    alert.show();

                    textField1.clear();  textField2.clear();   roleBox.setValue(null);   textField4.clear();   textField5.clear();
                    textField6.clear();  textField7.clear();   textField8.clear();     textField9.clear();   textField10.clear();
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid input. Please enter correct values.");
                    alert.show();
                }
            });

            Button backButton = new Button("Back");
            backButton.setPrefHeight(20);
            backButton.setPrefWidth(100);
            backButton.setStyle("-fx-text-fill: white; -fx-background-color: green; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 25px;");
            backButton.setOnAction(e -> {
                Stage currentStage = (Stage) backButton.getScene().getWindow();
                Scene scene1 = new Scene(new StackPane(), 1000,800);
                currentStage.setTitle("Team Players...!!!");
                currentStage.setScene(teamPlayersScene(currentStage,scene1,text));
            });

            Label label = new Label("Enter New Player Details...!!!");
            label.setPrefWidth(500);
            label.setPrefHeight(100);
            label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: green; -fx-border-color: black; -fx-border-width: 1px; -fx-background-color: rgb(227,233,191);");
            label.setAlignment(Pos.CENTER);


            VBox vBox = new VBox(10);
            vBox.setStyle("-fx-background-color: rgb(227,233,191); -fx-border-color: black; -fx-order-width: 1px;");
            vBox.setAlignment(Pos.CENTER);
            vBox.setMinWidth(500);
            vBox.setMinHeight(550);
            vBox.setMaxWidth(500);
            vBox.setMaxHeight(550);
            vBox.getChildren().addAll(hBox1,hBox2,hBox3,hBox4,hBox5,hBox6,hBox7,hBox8,hBox9,hBox10,addPlayer,backButton);

            vBox1.getChildren().addAll(label,vBox);
            vBox1.setStyle("-fx-background-color: rgb(215,223,163);");
            vBox1.setAlignment(Pos.CENTER);


            return new Scene(vBox1,1000,800);

        } else {
            Label label = new Label("Team" + text + "players are Complete...!!!");
            vBox1.getChildren().add(label);
            label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: red;");
            return new Scene(vBox1,1000,800);
        }
    }



    public int readPlayersFromFile(String text) {
        int counter = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(PLAYER_IN_TEAM_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] players = line.split(",");
                if(players[4].equals(text)) {
                    counter++;
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return counter;
    }


    public void savePlayersToFile(Player player) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(PLAYER_IN_TEAM_FILE,true));
            writer.newLine();
            writer.write(player.toString());
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }



    public Scene deletePlayerFromTeam(Stage stage, Scene scene, String text) {
        Label label = new Label("Enter the Player ID and Name you want to Delete...!!!");
        label.setPrefWidth(500);
        label.setPrefHeight(100);
        label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: green; -fx-border-color: black; -fx-border-width: 1px; -fx-background-color: rgb(227,233,191);");
        label.setAlignment(Pos.CENTER);

        Label idLabel = new Label("ID:  ");
        idLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        TextField textField1 = new TextField();
        textField1.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
        HBox hBox1 = new HBox(71);
        hBox1.setAlignment(Pos.CENTER_LEFT);
        hBox1.setPadding(new Insets(0,0,0,130));
        hBox1.getChildren().addAll(idLabel, textField1);


        Label nameLabel = new Label("Name:  ");
        nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        TextField textField2 = new TextField();
        textField2.setStyle("-fx-min-height: 30px; -fx-min-width: 160px; -fx-background-radius: 10px");
        HBox hBox2 = new HBox(40);
        hBox2.setAlignment(Pos.CENTER_LEFT);
        hBox2.setPadding(new Insets(0,0,20,130));
        hBox2.getChildren().addAll(nameLabel, textField2);


        Button deleteButton = new Button("Delete");
        deleteButton.setPrefHeight(20);
        deleteButton.setPrefWidth(100);
        deleteButton.setStyle("-fx-text-fill: white; -fx-background-color: green; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 25px;");
        deleteButton.setOnAction(e -> {
            String playerId = textField1.getText();
            String playerName = textField2.getText();

            if(deletePlayerFromFile(playerId,playerName,text)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Player Deleted successfully...!!!");
                alert.show();

                textField1.clear();   textField2.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Player not Found...!!!");
                alert.show();
            }
        });

        Button backButton = new Button("Back");
        backButton.setPrefHeight(20);
        backButton.setPrefWidth(100);
        backButton.setStyle("-fx-text-fill: white; -fx-background-color: green; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 25px;");
        backButton.setOnAction(e -> {
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            Scene scene1 = new Scene(new StackPane(), 1000,800);
            currentStage.setTitle("Team Players...!!!");
            currentStage.setScene(teamPlayersScene(currentStage,scene1,text));
        });

        VBox vBox = new VBox(20);
        vBox.setStyle("-fx-background-color: rgb(227,233,191); -fx-border-color: black; -fx-order-width: 1px;");
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinWidth(500);
        vBox.setMinHeight(400);
        vBox.setMaxWidth(500);
        vBox.setMaxHeight(400);
        vBox.getChildren().addAll(hBox1,hBox2,deleteButton,backButton);

        VBox vBox1 = new VBox();
        vBox1.setStyle("-fx-background-color: rgb(215,223,163);");
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(label,vBox);

        return new Scene(vBox1,1000,800);
    }



    public boolean deletePlayerFromFile(String id, String name, String teamName) {
        List<String> playerList1 = new ArrayList<>();
        boolean playerFound = false;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(PLAYER_IN_TEAM_FILE));
            String line;
            while((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                String playerID = details[1];
                String playerName = details[2];
                String playerTeam = details[5];

                if(!(playerID.equals(id) && playerName.equalsIgnoreCase(name) && playerTeam.equalsIgnoreCase(teamName))) {
                    playerList1.add(line);
                } else {
                    playerFound = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (playerFound) {
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(PLAYER_IN_TEAM_FILE));
                for(String player: playerList1) {
                    writer.write(player);
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return playerFound;
    }







}
