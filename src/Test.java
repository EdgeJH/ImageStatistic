import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by kim on 2017. 2. 8..
 */
public class Test {
    private static ArrayList<MapClass> mapClassArrayList = new ArrayList<>();

    private static ArrayList<MapClass3> mapClassArrayListrs2 = new ArrayList<>();
    private static ArrayList<Integer> xArray = new ArrayList<>();
    private static ArrayList<Integer> yArray = new ArrayList<>();
    private static ArrayList<Integer> ExArray = new ArrayList<>();
    private static ArrayList<Integer> EyArray = new ArrayList<>();
    private static double sumX = 0.0;
    private static double sumY = 0.0;
    private static double EsumX = 0.0;
    private static double EsumY = 0.0;

    public static void main(String[] args) {
        int rdX = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        int rdY = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        int rdX2 = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
        int rdY2 = ThreadLocalRandom.current().nextInt(-100, 100 + 1);

        int[] a = new int[700];
        int[] b = new int[700];
        if (rdX < rdY && rdX2 < rdY2) {
            for (int i = 0; i < 700; i++) {
                a[i] = ThreadLocalRandom.current().nextInt(rdX + 1, rdY + 1);
                b[i] = ThreadLocalRandom.current().nextInt(rdX2 + 1, rdY2 + 1);

                for (int j = 0; j < i; j++) {
                    if (a[i] == a[j] && b[i] == b[j]) {
                        i--;
                    } else {
                        if(j==i-1) {
                            xArray.add(a[i]);
                            yArray.add(b[i]);
                            ExArray.add(a[i]);
                            EyArray.add(b[i]);

                        }

                    }
                }
            }
            int ranX = ThreadLocalRandom.current().nextInt(1, 200 + 1);
            int ranY = ThreadLocalRandom.current().nextInt(1, 200 + 1);
            int ranZ = ThreadLocalRandom.current().nextInt(1, 200 + 1);
            int resultX = ranX * 300 / (ranX + ranY + ranZ);
            int resultY = ranY * 300 / (ranX + ranY + ranZ);
            int resultZ = ranZ * 300 / (ranX + ranY + ranZ);

            int[] c = new int[resultX+1];
            int[] d = new int[resultX+1];
            for (int i = 0; i < resultX; i++) {
                c[i] = ThreadLocalRandom.current().nextInt(-100, 0 + 1);
                d[i] = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                for (int j = 0; j < i; j++) {
                    if (c[i] == c[j] && d[i] == d[j]) {
                        i--;
                    } else {
                        if (j == i - 1) {
                            xArray.add(c[i]);
                            yArray.add(d[i]);

                        }
                    }
                }
            }
            int[] e = new int[resultY];
            int[] f = new int[resultY];
            for (int i = 0; i < resultY ; i++) {
                e[i] = ThreadLocalRandom.current().nextInt(-100, 0 + 1);
                f[i] = ThreadLocalRandom.current().nextInt(-100, 0 + 1);
                for (int j = 0; j < i; j++) {
                    if (e[i] == e[j] && f[i] == f[j]) {
                        i--;
                    } else {
                        if (j == i - 1) {
                            xArray.add(e[i]);
                            yArray.add(f[i]);
                        }
                    }
                }
            }
            int[] g = new int[resultZ];
            int[] h = new int[resultZ];
            for (int i = 0; i < resultZ; i++) {
                g[i] = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                h[i] = ThreadLocalRandom.current().nextInt(-100, 0 + 1);
                for (int j = 0; j < i; j++) {
                    if (g[i] == g[j] && h[i] == h[j]) {
                        i--;
                    } else {
                        if (j == i - 1) {
                            xArray.add(g[i]);
                            yArray.add(h[i]);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < ExArray.size(); i++) {
            EsumX += ExArray.get(i);
            EsumY += EyArray.get(i);
        }
        for (int i = 0; i < xArray.size(); i++) {
            MapClass mapClass = new MapClass();
            sumX += xArray.get(i);
            sumY += yArray.get(i);
            mapClass.setX(xArray.get(i));
            mapClass.setY(yArray.get(i));
            mapClassArrayList.add(mapClass);
        }
        int dd = 0;
        int count =0;
        for (int i = 0; i<mapClassArrayList.size();i++ ) {
            MapClass mapClass2;
            mapClass2 = mapClassArrayList.get(i);
            int keyXValue = mapClass2.getX();
            int keyYValue = mapClass2.getY();
            MapClass3 mapClass4 = new MapClass3();
            ArrayList<MapClass2> mapClassArrayListrs = new ArrayList<>();
            for (int j = 0; j < xArray.size(); j++) {
                MapClass2 mapClass3 =new MapClass2();
                count++;
                int areaX = xArray.get(j);
                int areaY = yArray.get(j);
                if (keyXValue - 15 < areaX && areaX < keyXValue + 15 && keyYValue - 15 < areaY && areaY < keyYValue + 15) {
                    mapClass3.setX(areaX);
                    mapClass3.setY(areaY);
                    mapClassArrayListrs.add(mapClass3);

                }

            }
            mapClass4.setSize(mapClassArrayListrs.size());
            mapClass4.setMapClass2ArrayList(mapClassArrayListrs);
            mapClassArrayListrs2.add(mapClass4);
        }
        System.out.print("연산횟수 : " +count);
        Desc desc = new Desc();
        int aa =0;
        int bb =0;
        Collections.sort(mapClassArrayListrs2,desc);
        for (int i=0; i<10; i++){
            MapClass3 mapClass6;
            mapClass6 = mapClassArrayListrs2.get(i);
            aa+=mapClass6.getMapClass2ArrayList().get(i).getX();
            bb+=mapClass6.getMapClass2ArrayList().get(i).getY();
            System.out.println("동률 데이터 : "+String.valueOf(mapClass6.getSize())+","
                    +String.valueOf(mapClass6.getMapClass2ArrayList().get(i).getX())+","
                    +String.valueOf(mapClass6.getMapClass2ArrayList().get(i).getY()));
        }
        Get_Distance gd = new Get_Distance();
        System.out.println("전체 x 평균 : "+sumX / 1000);
        System.out.println("전체 y 평균 : "+sumY / 1000);
        System.out.println("1차 x 평균 : "+aa/20);
        System.out.println("1차 y 평균 : "+bb/20);
        ArrayList<Integer> xArrayRs = new ArrayList<>();
        ArrayList<Integer> yArrayRs = new ArrayList<>();
        for (int i =0; i<mapClassArrayListrs2.size();i++){
            MapClass3 mapClass7;
            mapClass7 = mapClassArrayListrs2.get(i);
            int size = mapClass7.getSize();
            if (size==mapClassArrayListrs2.get(0).getSize()){
                xArrayRs.add(mapClass7.getMapClass2ArrayList().get(i).getX());
                yArrayRs.add(mapClass7.getMapClass2ArrayList().get(i).getY());
            }
        }
        int aX=0;
        int aY=0;
        for (int i =0; i<xArrayRs.size();i++){
            aX +=xArrayRs.get(i);
            aY +=yArrayRs.get(i);
        }
        int avX = aX/xArrayRs.size();
        int avY = aY/yArrayRs.size();
        System.out.println("동률 카운트 x 평균 : "+avX);
        System.out.println("동률 카운트 y 평균 : "+avY);
        int sigx =0;
        int sigy=0;
        System.out.println(xArrayRs.size());
        for (int i =0; i<xArrayRs.size(); i++) {
            int x = xArrayRs.get(i) - avX;
            int y = yArrayRs.get(i) - avY;
            if (x != 0 && y != 0) {
                sigx += Math.pow(xArrayRs.get(i) - avX, 2);
                sigy += Math.pow(yArrayRs.get(i) - avY, 2);
            }
        }

        double sigx2 = Math.sqrt(sigx/xArrayRs.size()-1);
        double sigy2 = Math.sqrt(sigy/yArrayRs.size()-1);
        ArrayList<Integer> xRs = new ArrayList<>();
        ArrayList<Integer> yRs = new ArrayList<>();
        for (int i = 0; i<xArrayRs.size(); i++){
            int x = xArrayRs.get(i);
            int y = yArrayRs.get(i);
            double zx = (x-avX)/sigx2;
            double zy = (y-avY)/sigy2;
            if (-1.96<=zx && zx<=1.96 && -1.96<=zy && zy<=1.96){
                xRs.add(x);
                yRs.add(y);
            }
        }
        int avXrs = 0;
        int avYrs = 0;
        for (int i = 0; i<xRs.size();i++){
            avXrs += xRs.get(i);
            avYrs += yRs.get(i);
        }
        try {
            System.out.println("표준편차 95% x 평균 : "+avXrs/xRs.size());
            System.out.println("표준편차 95% y 평균 : "+avYrs/yRs.size());
            System.out.println("전체평균과 표준편차 평균 두점 사이거리 : "+gd.getDistance(avXrs/xRs.size(), avYrs/yRs.size(), sumX / 1000, sumY / 1000));
        }catch (Exception e){
            System.out.println("동률 카운트가 1개 입니다");
        }

    }
    static class Desc implements Comparator<MapClass3>{

        @Override
        public int compare(MapClass3 o1, MapClass3 o2) {
            int first = o1.getSize();
            int second = o2.getSize();
            if (first > second) {
                return -1;
            } else if (first < second) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}