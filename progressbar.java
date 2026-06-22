import java.util.Scanner;

class Main {
    public static void printProgressBar(int percent) {
    int totalBlocks = 20; // Length of the bar
    // Calculate how many blocks should be filled
    int filledBlocks = (percent * totalBlocks) / 100; 
    
    StringBuilder bar = new StringBuilder("[");
    for (int j = 0; j < totalBlocks; j++) {
        if (j < filledBlocks) {
            bar.append("#");
        } else {
            bar.append(" ");
        }
    }
    bar.append("]");
    
    // \r moves the cursor back to the start of the line to overwrite it
    System.out.print("\r" + bar + " " + percent + "%");
}
    public static void main (String [] args) throws InterruptedException {
        Scanner cin = new Scanner(System.in);
        System.out.println("Hello, World!");
        System.out.print("What's your name: ");
        String name = cin.nextLine();
        System.out.print("How old are you (in years): ");
        int age = cin.nextInt();
        cin.nextLine();
        System.out.print("Which course are you pursuing: ");
        String course = cin.nextLine();
        System.out.print("In what school are you taking " + course + ": ");
        String school = cin.nextLine();
        System.out.print("What year are you expected to complete your coursework:");
        String year = cin.nextLine();
        
        System.out.println();
        System.out.print("\rConnecting to database server...");
        Thread.sleep(1500); // Simulating work
        
        // Extra spaces at the end clean up the remnants of the long database string
        System.out.print("\rCompiling data...                 "); 
        Thread.sleep(1500);
        
        System.out.print("\rGetting Report...                  ");
        Thread.sleep(1500);

    for (int i = 1; i <= 100; i++) {
        int currentPercent = (i * 100) / 100;
        printProgressBar(currentPercent);
        Thread.sleep(250);
    }
    System.out.println("\nReport Compiled successfully!");
    System.out.println();
    System.out.println("Select what to find out about the client:\n1.Full Name\n2. Course\n3. Age\n4. Year of Birth\n5. School\n6. Year of Graduation.");
    int choice = cin.nextInt();
    cin.nextLine();

    switch (choice) {
        case 1: System.out.println(name + ".");
            break;
        case 2: System.out.println(course + ".");
            break;
        case 3: System.out.println(age + "years old.");
            break;
        case 4: System.out.println(name + " was born in " +(2026 - age)+ ".");
            break;
        case 5: System.out.println(name + " studies in " + school);
            break;
        case 6: System.out.println(name + " is expected to graduate in " + year);
            break;
        default: System.out.println("Invalid Choice.");
            break;
            
    }
    cin.close();
}

};
