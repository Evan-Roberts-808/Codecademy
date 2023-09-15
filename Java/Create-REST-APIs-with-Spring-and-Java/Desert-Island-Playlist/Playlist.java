import java.util.ArrayList;

class Playlist {

    public static void main(String[] args) {

        ArrayList<String> desertIslandPlaylist = new ArrayList<String>();
        desertIslandPlaylist.add("Voices");
        desertIslandPlaylist.add("LosT");
        desertIslandPlaylist.add("Slaughterhosue");
        desertIslandPlaylist.add("Dear Diary,");
        desertIslandPlaylist.add("AmEN!");
        desertIslandPlaylist.add("Hated");
        // System.out.println(desertIslandPlaylist);
        // System.out.println(desertIslandPlaylist.size());
        desertIslandPlaylist.remove(5);
        // System.out.println(desertIslandPlaylist);
        // System.out.println(desertIslandPlaylist.size());
        int indexA = desertIslandPlaylist.indexOf("AmEN!");
        int indexB = desertIslandPlaylist.indexOf("Voices");
        String tempA = desertIslandPlaylist.get(indexA);
        desertIslandPlaylist.set(indexA, desertIslandPlaylist.get(indexB));
        desertIslandPlaylist.set(indexB, tempA);
        System.out.println(desertIslandPlaylist);
    }

}