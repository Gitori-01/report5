package jp.ac.uryukyu.ie.e195701;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 * Updated by gitori-01 on 2019/11/25.
 */
public class Enemy extends LivingThings {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        System.out.printf("%sが　あらわれた！\n\n", name);
    }

    @Override
    public void attack(LivingThings opponent) {
        int damage = (int)(Math.random() * getAttack());
        if (!isDead()){
            if (damage == 0){
                System.out.printf("%sの攻撃！うまくかわした！\n", getName());
            }else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }
            opponent.wounded(damage);
        }
    }

    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

}
