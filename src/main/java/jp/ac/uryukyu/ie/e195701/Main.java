package jp.ac.uryukyu.ie.e195701;

/**
 * Created by tnal on 2016/11/13.
 */
public class Main {
    public static void main(String[] args){
        Hero hero = new Hero("勇者", 10, 5);
        Enemy enemy = new Enemy("スライム", 6, 3);
        System.out.println(hero.status() + enemy.status());
        System.out.printf("%s vs. %s\n\n", hero.getName(), enemy.getName());

        int turn = 0;
        while(!hero.isDead() && !enemy.isDead()){
            if (turn > 0){System.out.println("\n" + hero.status() + enemy.status());}
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy);
            enemy.attack(hero);
        }
        System.out.println("\n戦闘終了");
    }
}
