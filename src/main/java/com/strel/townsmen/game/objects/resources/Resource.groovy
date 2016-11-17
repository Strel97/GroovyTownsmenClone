package com.strel.townsmen.game.objects.resources

/**
 * Created by strel on 13.06.15.
 */
abstract class Resource implements Cloneable {

    int id
    int amount


    @Override
    String toString() {
        " {$id} => $amount "
    }
}
