package org.soulmate.ordinary;

public class P1158 {
    /*
    select a.user_id buyer_id,a.join_date,case when b.cnt is null then 0 else b.cnt end orders_in_2019 from users a left join
    (select buyer_id,count(1) cnt from orders where year(order_date) = '2019' group by buyer_id) b on a.user_id = b.buyer_id
     */
}
