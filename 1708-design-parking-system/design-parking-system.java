class ParkingSystem {
    int[] parkingSpaces;

    public ParkingSystem(int big, int medium, int small) {
        this.parkingSpaces = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (parkingSpaces[carType] > 0) {
            parkingSpaces[carType] -= 1;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */