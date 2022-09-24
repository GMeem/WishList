package com.example.wishlist

class WishFetcher {
    companion object {

        fun addEmail(tle: String, prc: String, urL:String): MutableList<Wish> {
            var newEmails : MutableList<Wish> = ArrayList()
            val email = Wish(tle, prc, urL)
            newEmails.add(email)
            return newEmails
        }
    }
}