package my.practice.arrays;


public class TourPetrolPump {

	class PetrolPump {
		int petrol, dist;

		public PetrolPump(int petrol, int distance) {
			this.petrol = petrol;
			this.dist = distance;
		}
	}

	private int printTour(PetrolPump[] pumps, int len) {
		int start = 0;
		int end = 1;
		int currPetrol = pumps[start].petrol - pumps[start].dist;

		while (end != start || currPetrol < 0) {
			while (currPetrol < 0 && start != end) {
				currPetrol -= pumps[start].petrol - pumps[start].dist;
				start = (start + 1) % len;
				if (start == 0)
					return -1;
			}
			currPetrol += pumps[end].petrol - pumps[end].dist;
			end = (end + 1) % len;
		}
		return start;
	}

	public static void main(String[] args) {
		TourPetrolPump tour = new TourPetrolPump();
		PetrolPump[] pumps = { tour.new PetrolPump(4, 6), tour.new PetrolPump(6, 5), 
				tour.new PetrolPump(7, 3),
				tour.new PetrolPump(4, 5) 
				};

		int start = tour.printTour(pumps, pumps.length);
		if (start == -1) {
			System.out.println("No Route Exists!");
		} else {
			System.out.println("Start index: " + start);
		}
	}

}
