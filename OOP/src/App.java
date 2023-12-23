import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Asset {
    String assetName;
    String assetId;
    int amount;
    double maintenancePrice;
    Date maintenanceDate;
    boolean maintenanceStatus;

    public Asset(String assetName, String assetId, int amount, double maintenancePrice, Date maintenanceDate) {
        this.assetName = assetName;
        this.assetId = assetId;
        this.amount = amount;
        this.maintenancePrice = maintenancePrice;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceStatus = false; // Default status is pending
    }
}

public class App {
    private static final List<Asset> assets = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Asset Management System =====");
            System.out.println("1. Input, Edit, and Delete Assets");
            System.out.println("2. List of Assets");
            System.out.println("3. Search Assets by Date");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    manageAssets(scanner);
                    break;
                case 2:
                    listAssets();
                    break;
                case 3:
                    searchAssetsByDate(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void manageAssets(Scanner scanner) {
        while (true) {
            System.out.println("\n===== Asset Management =====");
            System.out.println("1. Input Asset");
            System.out.println("2. Edit Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    inputAsset(scanner);
                    break;
                case 2:
                    editAsset(scanner);
                    break;
                case 3:
                    deleteAsset(scanner);
                    break;
                case 4:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void inputAsset(Scanner scanner) {
        System.out.println("\n===== Input Asset =====");

        System.out.print("Enter Asset Name: ");
        String assetName = scanner.nextLine();

        System.out.print("Enter Asset ID: ");
        String assetId = scanner.nextLine();

        System.out.print("Enter Amount: ");
        int amount = scanner.nextInt();

        System.out.print("Enter Maintenance Price: ");
        double maintenancePrice = scanner.nextDouble();

        System.out.print("Enter Maintenance Date (dd-mm-yyyy): ");
        scanner.nextLine(); // Consume the newline character
        Date maintenanceDate = null;
        try {
            maintenanceDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd-mm-yyyy.");
            return;
        }

        assets.add(new Asset(assetName, assetId, amount, maintenancePrice, maintenanceDate));
        System.out.println("Asset added successfully!");
    }

    // ... (previous code remains unchanged)

private static void editAsset(Scanner scanner) {
    System.out.println("\n===== Edit Asset =====");

    if (assets.isEmpty()) {
        System.out.println("No assets available for editing.");
        return;
    }

    listAssets();

    System.out.print("Enter Asset ID to edit: ");
    String assetIdToEdit = scanner.nextLine();

    boolean found = false;
    for (Asset asset : assets) {
        if (asset.assetId.equals(assetIdToEdit)) {
            System.out.print("Enter new Maintenance Price: ");
            double newMaintenancePrice = scanner.nextDouble();
            asset.maintenancePrice = newMaintenancePrice;

            System.out.print("Enter new Maintenance Date (dd-mm-yyyy): ");
            scanner.nextLine(); // Consume the newline character
            try {
                Date newMaintenanceDate = dateFormat.parse(scanner.nextLine());
                asset.maintenanceDate = newMaintenanceDate;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use dd-mm-yyyy.");
                return;
            }

            System.out.print("Do you want to change the maintenance status? (Y/N): ");
            String changeStatus = scanner.nextLine().trim().toLowerCase();
            if (changeStatus.equals("y")) {
                System.out.print("Enter new Maintenance Status (Done/Pending): ");
                String newStatus = scanner.nextLine().trim().toLowerCase();
                asset.maintenanceStatus = newStatus.equals("done");
            }

            System.out.println("Asset edited successfully!");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Asset not found with ID: " + assetIdToEdit);
    }
}


    private static void deleteAsset(Scanner scanner) {
        System.out.println("\n===== Delete Asset =====");

        if (assets.isEmpty()) {
            System.out.println("No assets available for deletion.");
            return;
        }

        listAssets();

        System.out.print("Enter Asset ID to delete: ");
        String assetIdToDelete = scanner.nextLine();

        assets.removeIf(asset -> asset.assetId.equals(assetIdToDelete));
        System.out.println("Asset deleted successfully!");
    }

    private static void listAssets() {
        System.out.println("\n===== List of Assets =====");

        if (assets.isEmpty()) {
            System.out.println("No assets available.");
            return;
        }

        Collections.sort(assets, Comparator.comparing(asset -> asset.maintenanceDate));

        System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s\n",
                "Asset Name", "Asset ID", "Amount", "Maintenance Price", "Maintenance Date", "Status");

        for (Asset asset : assets) {
            System.out.printf("%-25s%-25s%-25d%-25f%-25s%s\n",
                    asset.assetName, asset.assetId, asset.amount, asset.maintenancePrice,
                    dateFormat.format(asset.maintenanceDate),
                    asset.maintenanceStatus ? "Done" : "Pending");
        }
    }

    private static void searchAssetsByDate(Scanner scanner) {
        System.out.println("\n===== Search Assets by Date =====");

        if (assets.isEmpty()) {
            System.out.println("No assets available for search.");
            return;
        }

        System.out.print("Enter date (dd-mm-yyyy, mm-yyyy, or yyyy): ");
        String dateString = scanner.nextLine();

        List<Asset> filteredAssets = new ArrayList<>();

        for (Asset asset : assets) {
            String assetDateString = dateFormat.format(asset.maintenanceDate);
            if (assetDateString.contains(dateString)) {
                filteredAssets.add(asset);
            }
        }

        if (filteredAssets.isEmpty()) {
            System.out.println("No assets found for the given date: " + dateString);
        } else {
            System.out.printf("%-20s%-15s%-10s%-20s%-15s%-10s\n",
                    "Asset Name", "Asset ID", "Amount", "Maintenance Price", "Maintenance Date", "Status");

            for (Asset asset : filteredAssets) {
                System.out.printf("%-20s%-15s%-10d%-20.2f%-15s%s\n",
                        asset.assetName, asset.assetId, asset.amount, asset.maintenancePrice,
                        dateFormat.format(asset.maintenanceDate),
                        asset.maintenanceStatus ? "Done" : "Pending");
            }
        }
    }
}
