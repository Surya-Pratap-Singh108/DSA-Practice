class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        int fleets = 0;
        double lastTime = 0;

        for (int i = position.length - 1; i >= 0; i--) {

            double time = (double)(target - position[i]) / map.get(position[i]);

            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }
}