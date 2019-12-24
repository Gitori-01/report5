package jp.ac.uryukyu.ie.e195701;

/**
 * ヒーローと敵の親クラス。
 * String name; //キャラクターの名前
 *  int hitPoint; //キャラクターのHP
 *  int attack; //キャラクターの攻撃力
 *  boolean dead; //キャラクターの生死状態。true=死亡。
 *  Created by gitori-01 on 2019/11/25.
 */
public class LivingThings {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 個体名
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public LivingThings (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * deadのセッター
     * @param dead
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * nameのゲッター
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * attackのゲッター
     * @return int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * hitPointのゲッター
     * @return int
     */
    public int getHitPoint() {
        return hitPoint;
    }

    /**
     * hitpointのセッター
     * @param hitPoint
     */
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    /**
     * 現在のステータスを返すメソッド。
     * @return String
     */
    public String status(){
        return String.format("%s\n HP  %2d\n ATK %2d\n", name, hitPoint, attack);
    }

    /**
     * 敵対する個体に攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThings opponent){

        if (!dead){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
