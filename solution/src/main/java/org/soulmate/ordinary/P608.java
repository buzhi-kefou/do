package org.soulmate.ordinary;

public class P608 {

    /*
    select distinct self.id, case
                    when self.p_id is null then "Root"
                    when child.p_id is null then "Leaf"
                    else "Inner"
                end Type
    from tree self left join tree child on self.id = child.p_id;
     */
}
