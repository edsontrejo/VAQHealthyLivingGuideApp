
package Environment.Models;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.image.Image;
import javax.xml.bind.DatatypeConverter;

import Environment.Database.Database;
import Environment.MainApplication;
import Environment.Classes.Profile;
import Environment.Classes.Allergy;
import Environment.Classes.Equipment;
import Environment.Classes.Disease;
import Environment.Classes.Exercise;
import Environment.Classes.Exercise.ExerciseTypeE;
import Environment.Classes.Exercise.MuscleTypeE;
import Environment.Classes.ExerciseRoutine;
import Environment.Classes.WeeklyRoutine;
import Environment.Core.Tools;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginModel {
    
    static private ArrayList<Allergy> allergyList = new ArrayList<>();
    static private ArrayList<Disease> diseaseList = new ArrayList<>();
    static private ArrayList<Equipment> equipmentList = new ArrayList<>();
    
    static Database instance = MainApplication.getDatabase();
    static Tools tools = MainApplication.getTools();
    static Connection connection = instance.getMyConnection();
 
    public static void AddWeeklyRoutine(WeeklyRoutine routine) {

    }

    public static void AddUser(String username, String password, String email) {

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            String hashedUsername = sha256(username);
            String hashedPassword = sha256(password);

            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("SELECT COUNT(*) FROM user");
            myRs.next();
            int rowCount = myRs.getInt(1) + 1;
            String sql = "INSERT INTO User (ID, username, password) VALUES (?, ?, ?)";
            String sql2 = "INSERT INTO profilepicture (userID) VALUES (?)";
            String sql3 = "INSERT INTO medical (userID) VALUES (?)";
            String sql4 = "INSERT INTO personal (userID) VALUES (?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            PreparedStatement statement3 = connection.prepareStatement(sql3);
            PreparedStatement statement4 = connection.prepareStatement(sql4);
            statement.setInt(1, rowCount);
            statement.setString(2, hashedUsername);
            statement.setString(3, hashedPassword);
            statement2.setInt(1, rowCount);
            statement3.setInt(1, rowCount);
            statement4.setInt(1, rowCount);

            int rowsInserted = statement.executeUpdate();
            int rowsInserted2 = statement2.executeUpdate();
            int rowsInserted3 = statement3.executeUpdate();
            int rowsInserted4 = statement4.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public static boolean UsernameExists(String username) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        boolean found = false;
        String hashedUsername = sha256(username);

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM user WHERE username='" + hashedUsername + "'");
            // 4. Process the result set
            while (myRs.next()) {
                found = true;
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return found;
    }

    public static boolean UserExists(String username, String password) {
        boolean found = false;
        String hashedUsername = "";
        String hashedPassword = "";
        try {
            hashedUsername = sha256(username);
            hashedPassword = sha256(password);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        } catch (UnsupportedEncodingException ex) {
            System.err.println(ex);
        }

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("select* from user where username='" + hashedUsername + "' and password='" + hashedPassword + "'");
            // 4. Process the result set
            while (myRs.next()) {
                found = true;
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return found;
    }

    public static ArrayList<String> GetExerEquipList() {
        ArrayList<String> equipList = new ArrayList<>();

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();

            myRs = myStmt.executeQuery("select* from equipment");
            // 4. Process the result set
            while (myRs.next()) {
                equipList.add(myRs.getString("name"));
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return equipList;
    }

    public static ArrayList<Exercise> GetExerciseList() {
        ArrayList<Exercise> exerciseList = new ArrayList<>();

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("select* from exercise");

            // 4. Process the result set
            while (myRs.next()) {
                Exercise newExercise = new Exercise();
                newExercise.setName(myRs.getString("Name"));
                newExercise.setDifficulty(myRs.getString("difficulty"));
                newExercise.setDescription(myRs.getString("description"));
                newExercise.setType(ExerciseTypeE.valueOf(myRs.getString("type")));
                newExercise.setMuscleTypeE(MuscleTypeE.valueOf(myRs.getString("primaryMuscle")));
                newExercise.setMet(myRs.getDouble("met"));
                newExercise.setEquipment(GetEquipment(myRs.getInt("equipmentID")));
                String imageFileName = "";
                imageFileName = myRs.getString("image");
                String exerciseType ="";
                if ((newExercise.getType().equals(ExerciseTypeE.STRENGTH)))
                        exerciseType = "Strength";
                else  if ((newExercise.getType().equals(ExerciseTypeE.CARDIO)))
                        exerciseType = "Cardio";
                 else  if ((newExercise.getType().equals(ExerciseTypeE.BALANCE)))
                        exerciseType = "Balance";
                 else  if ((newExercise.getType().equals(ExerciseTypeE.FLEXIBILITY)))
                        exerciseType = "Flexibility";
                System.out.println(imageFileName);
                newExercise.setImage(new Image("resources/images/"+exerciseType+"/"+imageFileName));
                
//                if (!imageFileName.equals(""))
//                {
//                    String filePath = "resources/images/Exercises/"+newExercise.getType().toString()+"/"+imageFileName;
//                    newExercise.setImage(new Image("images/Exercises/STRENGTH/Abdominal-crunch.jpg"));
//                }
//                if ()
//                Blob blob = myRs.getBlob("image");
//                if (blob != null)
//                {
//                    byte[] byteImage = blob.getBytes(1, (int) blob.length());
//                    newExercise.setImage(new Image(new ByteArrayInputStream(byteImage),150,100,false,false));
//                }
                exerciseList.add(newExercise);
            }

            
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return exerciseList;
    }

    
    
    private static void CreateMedical(Profile profile)
    {
         try {            
             String sql = "INSERT INTO medical (userID,heightFt,heightInches,weight) VALUES (?,?,?,?)";         
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, profile.id);
             statement.setInt(2, Integer.parseInt(profile.medical.getHeightFt()));
             statement.setInt(3, Integer.parseInt(profile.medical.getHeightInches()));
             statement.setInt(4, Integer.parseInt(profile.medical.getWeight()));
             statement.executeUpdate();
             
         }catch(Exception e)
         {
             System.out.println("Failed Create Medical");
         }
    }
    
    public static void UpdateMedical(Profile profile) {

        int userID, allergyID, diseaseID;
        try {
            Statement myStmt = null;
            ResultSet myRs;
           

            //Medical
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE medical SET "
                    + "weight = ?, "
                    + "heightFt = ?, "
                    + "heightInches = ? "
                    + "where userID = ?"
            );
            ps.setInt(1, Integer.parseInt(profile.medical.getWeight()));
            ps.setInt(2,Integer.parseInt(profile.medical.getHeightFt()));
            ps.setInt(3, Integer.parseInt(profile.medical.getHeightInches()));
            ps.setInt(4,profile.id);
            
            try{
                ps.executeUpdate();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to find user");
            }
            myStmt = connection.createStatement();
            //Allergies
            for (int i = 0; i < allergyList.size(); i++) {
                myRs = myStmt.executeQuery("select* from allergy where description='" + allergyList.get(i) + "'");
                myRs.next();
                allergyID = myRs.getInt("ID");
                Allergy allergy = allergyList.get(i);
                if (profile.medical.allergyList.contains(allergy)) {
                    myRs = myStmt.executeQuery("select* from userAllergies where userID=" + profile.id + " AND allergyID=" + allergyID);
                    if (myRs.next()) {
                        System.out.println("User already has allergy listed");
                    } else {
                        System.out.println("Listing User: " + profile.username + " Allergy: " + allergyList.get(i));
                        String sql = "INSERT INTO userAllergies (userID,allergyID) VALUES (?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setInt(1, profile.id);
                        statement.setInt(2, allergyID);
                        statement.executeUpdate();
                    }
                } else {
                    myRs = myStmt.executeQuery("select* FROM userAllergies where userID=" + profile.id + " AND allergyID=" + allergyID);
                    if (myRs.next()) {
                        System.out.println("Removing allergy from user in userAllergies Table");
                        String SQL = "DELETE FROM userAllergies WHERE userID = ? and allergyID = ? ";
                        PreparedStatement pstmt = null;
                        pstmt = connection.prepareStatement(SQL);
                        pstmt.setInt(1, profile.id);
                        pstmt.setInt(2, allergyID);
                        pstmt.executeUpdate();
                    }
                }
            }

            //Diseases
            for (int i = 0; i < diseaseList.size(); i++) {
                myRs = myStmt.executeQuery("select* from disease where name='" + diseaseList.get(i) + "'");
                myRs.next();
                diseaseID = myRs.getInt("ID");
                Disease disease = diseaseList.get(i);
                if (profile.medical.diseaseList.contains(disease)) {
                    myRs = myStmt.executeQuery("select* from userDiseases where userID=" + profile.id + " AND diseaseID=" + diseaseID);
                    if (myRs.next()) {
                        System.out.println("User already has disease listed");
                    } else {
                        System.out.println("Listing User: " + profile.username + " Disease: " + diseaseList.get(i));
                        String sql = "INSERT INTO userDiseases (userID,diseaseID) VALUES (?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setInt(1, profile.id);
                        statement.setInt(2, diseaseID);
                        statement.executeUpdate();
                    }
                } else {
                    myRs = myStmt.executeQuery("select* FROM userDiseases where userID=" + profile.id + " AND diseaseID=" + diseaseID);
                    if (myRs.next()) {
                        System.out.println("Removing disease from user in userAllergies Table");
                        String SQL = "DELETE FROM userDiseases WHERE userID = ? and diseaseID = ? ";
                        PreparedStatement pstmt = null;
                        pstmt = connection.prepareStatement(SQL);
                        pstmt.setInt(1, profile.id);
                        pstmt.setInt(2, diseaseID);
                        pstmt.executeUpdate();
                    }
                }
                
            }
        } catch (Exception e) {
        }

    }

    public static void UpdateExerciseProfile(Profile profile) {
        int equipmentID;
        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();

            //Update Equipment List
            for (int i = 0; i < equipmentList.size(); i++) {
                myRs = myStmt.executeQuery("select* from equipment where name='" + equipmentList.get(i).getName() + "'");
                myRs.next();
                equipmentID = myRs.getInt("ID");
                Equipment equipment = equipmentList.get(i);
                if (profile.exerciseProfile.equipmentList.contains(equipment)) {
                    myRs = myStmt.executeQuery("select* from userEquipment where userID=" + profile.id + " AND equipmentID=" + equipmentID);
                    if (myRs.next()) {
                        System.out.println("User already has equipment listed");
                    } else {
                        System.out.println("Listing User: " + profile.username + " Equipment: " + equipmentList.get(i));
                        String sql = "INSERT INTO userEquipment (userID,equipmentID) VALUES (?, ?)";
                        PreparedStatement statement = myConnection.prepareStatement(sql);
                        statement.setInt(1, profile.id);
                        statement.setInt(2, equipmentID);
                        statement.executeUpdate();
                    }
                } else {
                    myRs = myStmt.executeQuery("select* FROM userEquipment where userID=" + profile.id + " AND equipmentID=" + equipmentID);
                    if (myRs.next()) {
                        System.out.println("Removing equipment from user in userEquipment Table");
                        String SQL = "DELETE FROM userEquipment WHERE userID = ? and equipmentID = ? ";
                        PreparedStatement pstmt = null;
                        pstmt = myConnection.prepareStatement(SQL);
                        pstmt.setInt(1, profile.id);
                        pstmt.setInt(2, equipmentID);
                        pstmt.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
        }

    }

    public static void UpdatePersonal(Profile profile) {
        String hashedUsername = "";

        try {
            Connection myConnection  = connection;
            Statement myStmt = null;
            ResultSet myRs = null;
            hashedUsername = sha256(profile.username);
            PreparedStatement ps = myConnection.prepareStatement(
                    "UPDATE personal SET "
                    + "firstName = ?, "
                    + "lastName = ?, "
                    + "address = ?, "
                    + "city = ?, "
                    + "state = ?, "
                    + "zipcode = ?, "
                    + "sex = ?, "
                    + "birthday = ? "
                    + "WHERE userID=" + profile.id);
            ps.setString(1, profile.personal.getFname());
            ps.setString(2, profile.personal.getlName());
            ps.setString(3, profile.personal.getAddress());
            ps.setString(4, profile.personal.getCity());
            ps.setString(5, profile.personal.getState());
            ps.setString(6, profile.personal.getZipCode());
            ps.setString(7, profile.personal.getSex());
            if (tools.isValidDate(profile.personal.getBirthday().toString())) {
                ps.setDate(8, profile.personal.getBirthday());
            } else {
                ps.setDate(9, java.sql.Date.valueOf("2000-01-01"));
            }
            ps.executeUpdate();
            ps.close();

            if (profile.imagePath != null) {
                File imgfile = new File(profile.imagePath);
                FileInputStream fin = new FileInputStream(imgfile);
                String sql ="UPDATE profilePicture SET image = ? WHERE userID = " + profile.id;
                PreparedStatement pre = myConnection.prepareStatement(sql);
                pre.setBinaryStream(1, (InputStream) fin, (int) imgfile.length());
                pre.executeUpdate();
                System.out.println("Successfully inserted the file into the database!");

            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public static Profile GetProfile(String username) {
        Profile profile = new Profile();
        String hashedUsername = "";

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            hashedUsername = sha256(username);

            //Get UserID
            myRs = myStmt.executeQuery("SELECT * FROM user WHERE username = '" + hashedUsername + "'");
            myRs.next();
            int userID = myRs.getInt("ID");
            profile.id = userID;

            //Get Personal
            myRs = myStmt.executeQuery("SELECT * FROM personal WHERE userID = " + userID + "");
            while (myRs.next()) {
                profile.personal.setFname(myRs.getString("firstName"));
                profile.personal.setlName(myRs.getString("lastName"));
                profile.personal.setAddress(myRs.getString("address"));
                profile.personal.setSex(myRs.getString("sex"));
                profile.personal.setState(myRs.getString("state"));
                profile.personal.setCity(myRs.getString("city"));
                profile.personal.setZipCode(myRs.getString("zipcode"));
                profile.personal.setEmail(myRs.getString("email"));
                profile.personal.setBirthday(myRs.getDate("birthday"));
            }

            //Get Medical
            myRs = myStmt.executeQuery("SELECT * FROM medical WHERE userID=" + userID + "");
            myRs.next();
            profile.medical.setHeightFt((!myRs.getString("heightFt").equals(null)) ? myRs.getString("heightFt") : "");
            profile.medical.setHeightInches((!myRs.getString("heightInches").equals(null)) ? myRs.getString("heightInches") : "");
            profile.medical.setWeight((!myRs.getString("weight").equals(null)) ? myRs.getString("weight") : "");

            //Get Allergies
            myRs = myStmt.executeQuery(""
                    + "SELECT * FROM allergy a Inner Join("
                    + "SELECT * FROM userAllergies where userID = " + userID + ""
                    + ")AS t1 ON t1.allergyID =a.ID"
            );

            //myRs.next();
            while (myRs.next()) {
                Allergy allergy = new Allergy(myRs.getString("description"), myRs.getString("description"));
                profile.medical.allergyList.add(allergy);
                //System.out.println(myRs.getString("description"));
            }

            //Get Diseases      
            myRs = myStmt.executeQuery(""
                    + "Select* from disease a Inner Join("
                    + "Select* from userDiseases where userID=" + userID + ""
                    + ")AS t1 ON t1.diseaseID =a.ID"
            );

            //myRs.next();
            while (myRs.next()) {
                Disease disease = new Disease(myRs.getString("name"), myRs.getString("description"));
                profile.medical.diseaseList.add(disease);
            }

            //Get Equipment
            myRs = myStmt.executeQuery(""
                    + "Select* from equipment a Inner Join("
                    + "Select* from userEquipment where userID=" + userID + ""
                    + ")AS t1 ON t1.equipmentID =a.Id"
            );

            while (myRs.next()) {
                Equipment equipment = new Equipment(myRs.getString("name"), ExerciseTypeE.valueOf(myRs.getString("Exercise Type")));
                profile.exerciseProfile.equipmentList.add(equipment);
                //System.out.println(myRs.getString("name"));
            }

            //Get Profile Picture
            myRs = myStmt.executeQuery("SELECT * FROM profilePicture WHERE userID = " + userID + "");
            myRs.next();
            Blob blob = myRs.getBlob("image");
            byte[] byteImage = blob.getBytes(1, (int) blob.length());
            profile.profileImage = new Image(new ByteArrayInputStream(byteImage));

            //Get Medical
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return profile;
    }

    static private String sha256(String username) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(username.getBytes("UTF-8"));
        //System.out.println(DatatypeConverter.printHexBinary(hash));
        return DatatypeConverter.printHexBinary(hash);
    }

    public static ArrayList<Allergy> GetAllergyList() {

        allergyList.clear();
        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();

            myRs = myStmt.executeQuery("select* from allergy");
            // 4. Process the result set
            while (myRs.next()) {
                Allergy allergy = new Allergy(myRs.getString("name"), myRs.getString("description"));
                allergyList.add(allergy);
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return allergyList;
    }

    public static ArrayList<Equipment> GetEquipmentList() {

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            equipmentList.clear();
            myRs = myStmt.executeQuery("select* from equipment");
            // 4. Process the result set
            while (myRs.next()) {
                Equipment equipment = GetEquipment(myRs.getInt("Id"));
                equipmentList.add(equipment);
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return equipmentList;
    }

    public static ArrayList<Disease> GetDiseaseList() {
        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            diseaseList.clear();
            myRs = myStmt.executeQuery("select* from disease");
            while (myRs.next()) {
                Disease disease = new Disease(myRs.getString("name"), myRs.getString("description"));
                diseaseList.add(disease);
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return diseaseList;
    }

    //UserID, RoutineID
    public static ArrayList<WeeklyRoutine> GetUserWeeklyRoutines(int userID) {
        ArrayList<WeeklyRoutine> weeklyRoutines = new ArrayList<WeeklyRoutine>();

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM userWeeklyRoutine WHERE userID = " + userID);
            while (myRs.next()) {
                Connection myConnection2 = null;
                Statement myStmt2 = null;
                ResultSet myRs2 = null;             
                weeklyRoutines.add(GetWeeklyRoutine(myRs.getInt("WeeklyRoutineID")));             
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return weeklyRoutines;
    }
    public static void UpdateWeeklyRoutine(int userID, WeeklyRoutine weeklyRoutine) {
        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("select* from currentWeeklyRoutine where userID=" + userID);
            int weeklyRoutineID = myRs.getInt("WeeklyRoutineID");
            for (int i=0; i <weeklyRoutine.monday.size(); i++)
            {
                String sqlStr = "Update weeklyRoutine SET isDone=? where ID=" + weeklyRoutineID + "and workOutDay='Monday' and seqNum="+i;
                PreparedStatement ps = connection.prepareStatement(sqlStr);
                ps.setBoolean(1, true);
                ps.executeUpdate();
                ps.close();
            }
            
            
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    
    public static WeeklyRoutine GetUserCurrentWeeklyRoutine(int userID) {
        WeeklyRoutine weeklyRoutine = new WeeklyRoutine();

        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("select* from currentWeeklyRoutine where userID=" + userID);
            while (myRs.next()) {              
                 weeklyRoutine = GetWeeklyRoutine(myRs.getInt("WeeklyRoutineID"));             
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return weeklyRoutine;
    }
    
    
    
     public static void CreateUserCurrentWeeklyRoutine(Profile profile) {
        WeeklyRoutine weeklyRoutine = new WeeklyRoutine();
        int allergyID = 0;
        try {
           String sql = "INSERT INTO currentWeeklyRoutine (userID) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, profile.id);
            statement.executeUpdate();
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static WeeklyRoutine GetWeeklyRoutine(int weeklyRoutineID)
    {
        WeeklyRoutine newWeeklyRoutine = new WeeklyRoutine();
        try{
            Connection myConnection2 = null;
            Statement myStmt2 = null;
            ResultSet myRs2 = null;

            myStmt2 = connection.createStatement();
            
            myRs2 = myStmt2.executeQuery("select* from weeklyRoutine where ID=" + weeklyRoutineID + " and workOutDay='Monday' Order by seqNum");
            
            while (myRs2.next()) {
                newWeeklyRoutine.setName(myRs2.getString("name"));
                Connection myConnection3 = null;
                Statement myStmt3 = null;
                ResultSet myRs3 = null;
                myStmt3 = connection.createStatement();
                myRs3 = myStmt3.executeQuery("select* from exerciseRoutine where ID=" + myRs2.getInt("exerciseRoutineID"));
                myRs3.next();
                ExerciseRoutine exerciseRoutine = new ExerciseRoutine(GetExercise(myRs3.getInt("exerciseID")), myRs3.getDouble("workOutTime"));
                newWeeklyRoutine.monday.add(exerciseRoutine);
            }
            
             myRs2 = myStmt2.executeQuery("select* from weeklyRoutine where ID=" + weeklyRoutineID + " and workOutDay='Tuesday' Order by seqNum");
            
            while (myRs2.next()) {
                newWeeklyRoutine.setName(myRs2.getString("name"));
                Connection myConnection3 = null;
                Statement myStmt3 = null;
                ResultSet myRs3 = null;
                myStmt3 = connection.createStatement();
                myRs3 = myStmt3.executeQuery("select* from exerciseRoutine where ID=" + myRs2.getInt("exerciseRoutineID"));
                myRs3.next();
                ExerciseRoutine exerciseRoutine = new ExerciseRoutine(GetExercise(myRs3.getInt("exerciseID")), myRs3.getDouble("workOutTime"));
                newWeeklyRoutine.tuesday.add(exerciseRoutine);
            }
            
             myRs2 = myStmt2.executeQuery("select* from weeklyRoutine where ID=" + weeklyRoutineID + " and workOutDay='Wednesday' Order by seqNum");
            
            while (myRs2.next()) {
                newWeeklyRoutine.setName(myRs2.getString("name"));
                Connection myConnection3 = null;
                Statement myStmt3 = null;
                ResultSet myRs3 = null;
                myStmt3 = connection.createStatement();
                myRs3 = myStmt3.executeQuery("select* from exerciseRoutine where ID=" + myRs2.getInt("exerciseRoutineID"));
                myRs3.next();
                ExerciseRoutine exerciseRoutine = new ExerciseRoutine(GetExercise(myRs3.getInt("exerciseID")), myRs3.getDouble("workOutTime"));
                newWeeklyRoutine.wednesday.add(exerciseRoutine);
            }
            
             myRs2 = myStmt2.executeQuery("select* from weeklyRoutine where ID=" + weeklyRoutineID + " and workOutDay='Thursday' Order by seqNum");
            
            while (myRs2.next()) {
                newWeeklyRoutine.setName(myRs2.getString("name"));
                Connection myConnection3 = null;
                Statement myStmt3 = null;
                ResultSet myRs3 = null;
                myStmt3 = connection.createStatement();
                myRs3 = myStmt3.executeQuery("select* from exerciseRoutine where ID=" + myRs2.getInt("exerciseRoutineID"));
                myRs3.next();
                ExerciseRoutine exerciseRoutine = new ExerciseRoutine(GetExercise(myRs3.getInt("exerciseID")), myRs3.getDouble("workOutTime"));
                newWeeklyRoutine.thursday.add(exerciseRoutine);
            }
            
            
             myRs2 = myStmt2.executeQuery("select* from weeklyRoutine where ID=" + weeklyRoutineID + " and workOutDay='Friday' Order by seqNum");
            
            while (myRs2.next()) {
                newWeeklyRoutine.setName(myRs2.getString("name"));
                Connection myConnection3 = null;
                Statement myStmt3 = null;
                ResultSet myRs3 = null;
                myStmt3 = connection.createStatement();
                myRs3 = myStmt3.executeQuery("select* from exerciseRoutine where ID=" + myRs2.getInt("exerciseRoutineID"));
                myRs3.next();
                ExerciseRoutine exerciseRoutine = new ExerciseRoutine(GetExercise(myRs3.getInt("exerciseID")), myRs3.getDouble("workOutTime"));
                newWeeklyRoutine.friday.add(exerciseRoutine);
            }
            
            
             myRs2 = myStmt2.executeQuery("select* from weeklyRoutine where ID=" + weeklyRoutineID + " and workOutDay='Saturday' Order by seqNum");
            
            while (myRs2.next()) {
                newWeeklyRoutine.setName(myRs2.getString("name"));
                Connection myConnection3 = null;
                Statement myStmt3 = null;
                ResultSet myRs3 = null;
                myStmt3 = connection.createStatement();
                myRs3 = myStmt3.executeQuery("select* from exerciseRoutine where ID=" + myRs2.getInt("exerciseRoutineID"));
                myRs3.next();
                ExerciseRoutine exerciseRoutine = new ExerciseRoutine(GetExercise(myRs3.getInt("exerciseID")), myRs3.getDouble("workOutTime"));
                newWeeklyRoutine.saturday.add(exerciseRoutine);
            }
            
            myRs2 = myStmt2.executeQuery("select* from weeklyRoutine where ID=" + weeklyRoutineID + " and workOutDay='Sunday' Order by seqNum");
            
            while (myRs2.next()) {
                newWeeklyRoutine.setName(myRs2.getString("name"));
                Connection myConnection3 = null;
                Statement myStmt3 = null;
                ResultSet myRs3 = null;
                myStmt3 = connection.createStatement();
                myRs3 = myStmt3.executeQuery("select* from exerciseRoutine where ID=" + myRs2.getInt("exerciseRoutineID"));
                myRs3.next();
                ExerciseRoutine exerciseRoutine = new ExerciseRoutine(GetExercise(myRs3.getInt("exerciseID")), myRs3.getDouble("workOutTime"));
                newWeeklyRoutine.sunday.add(exerciseRoutine);
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return newWeeklyRoutine;
    }
    
    public static Exercise GetExercise(int exerciseID) {
        Exercise exercise = new Exercise();
        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("select* from exercise where ID=" + exerciseID);
            myRs.next();
            exercise.setName(myRs.getString("name"));
            exercise.setType(ExerciseTypeE.valueOf(myRs.getString("type")));
            exercise.setDescription(myRs.getString("description"));
            exercise.setMet(myRs.getDouble("MET"));
            exercise.setDifficulty(myRs.getString("Difficulty"));
            exercise.setDescription(myRs.getString("description"));
            Blob b = myRs.getBlob("image");
            if (b != null)
            {
                 byte[] byteImage = b.getBytes(1, (int) b.length());
                Image exerciseImg = new Image(new ByteArrayInputStream(byteImage));
                exercise.setImage(exerciseImg);
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return exercise;
    }

    public static Equipment GetEquipment(int equipmentID) {
        Equipment equipment = new Equipment();
        try {
            Connection myConnection = null;
            Statement myStmt = null;
            ResultSet myRs;
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("select* from equipment where ID=" + equipmentID);
            if (myRs.next())
            {
                equipment.setName(myRs.getString("Name"));
                equipment.setType(ExerciseTypeE.valueOf(myRs.getString("Exercise Type")));
                equipment.setDescription(myRs.getString("Description"));
                equipment.setPrimaryMuscle(myRs.getString("Primary Muscle"));
                equipment.setPrimaryMuscle(myRs.getString("Secondary Muscle"));
               
                String imageFileName = "";
                imageFileName = myRs.getString("Image");              
                equipment.setImage(new Image("resources/images/Equipment/"+imageFileName));    
                System.out.println(imageFileName);
            }
            
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return equipment;
    }
}
