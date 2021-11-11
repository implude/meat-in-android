package app.meatin.domain.model

object FakeValues {
    val HEARTED_TRUE = Heart(
        1,
        true
    )
    val HEARTED_FALSE = Heart(
        0,
        false
    )
    val BADGE = Badge(
        "https://media.discordapp.net/attachments/880049130813132842/900366666486132786/gold_class.png",
        "유사 백선생",
        "백선생급의 어마어마한 요리사",
        ""
    )
    val BRIEF_BADGE = BriefBadge(
        "https://media.discordapp.net/attachments/880049130813132842/900366666486132786/gold_class.png",
        "유사 백선생",
        ""
    )
    val BRIEF_COMMUNITY_USER = BriefCommunityUser(
        "김응애",
        "https://i.picsum.photos/id/839/200/200.jpg?hmac=IKyeqXa3iOwFkcM24B_X_Qjf9643wuDTCsTiM3T6AZg",
        BRIEF_BADGE,
        ""
    )
    val BRIEF_POST = BriefPost(
        BRIEF_COMMUNITY_USER,
        1634734699000,
        HEARTED_TRUE,
        1,
        "짜잔 맛있는 감자랍니다~",
        "https://media.discordapp.net/attachments/880049130813132842/900371003039948830/IMG_2593.png",
    )
    val MEAT_TYPE = MeatType(
        "문어고기",
        ""
    )
    val DIFFICULTY = Difficulty(
        "어려움",
        8,
    )
    val BRIEF_RECIPE = BriefRecipe(
        "맛있는 문어고기",
        "문어고기는 역시 맛있죠",
        "https://media.discordapp.net/attachments/880049130813132842/900371003039948830/IMG_2593.png",
        MEAT_TYPE,
        10,
        DIFFICULTY,
        1634734699000,
        HEARTED_FALSE,
        ""
    )
    val COMMENT = Comment(
        "사장님이 맛있고 음식이 친절해요",
        1634734699000,
        BRIEF_COMMUNITY_USER,
        "사장님이 너무 맛있고 음식이 완전 친절해요~ 또 오고 싶네요^^",
        ""
    )
    val COMMUNITY_USER = CommunityUser(
        "김응애",
        "https://i.picsum.photos/id/839/200/200.jpg?hmac=IKyeqXa3iOwFkcM24B_X_Qjf9643wuDTCsTiM3T6AZg",
        BRIEF_BADGE,
        listOf(BADGE, BADGE),
        listOf(BRIEF_POST, BRIEF_POST),
        listOf(BRIEF_RECIPE, BRIEF_RECIPE),
        ""
    )
    val INGREDIENT = Ingredient(
        "문어",
        "1개",
        "빨간 문어",
        true,
        ""
    )
    val POST = Post(
        listOf(
            "https://media.discordapp.net/attachments/880049130813132842/900371003039948830/IMG_2593.png",
            "https://media.discordapp.net/attachments/880049130813132842/900371003039948830/IMG_2593.png"
        ),
        "주말엔 역시 문어고기",
        1634734699000,
        BRIEF_COMMUNITY_USER,
        "오늘은 회사 쉬는 날이라 오랜만에 맥북 켜고 문어를 익혀 먹어봤어요!!",
        BRIEF_RECIPE,
        listOf(COMMENT, COMMENT, COMMENT, COMMENT),
        HEARTED_TRUE,
        true,
        ""
    )
    val RECIPE = Recipe(
        "맛있는 문어고기",
        "문어고기는 역시 맛있죠",
        "/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAMCAggICggICAkICQkJCAgHCAgGCAcHCQgJBgYHBwcHBwcHBwcHCAgICAcHBQoHBQcICQkJBwcLDQoIDQcICQgBAwQEBgUGCgYGCg0NCg0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQgIDQgNCAgNCP/AABEIAQABAAMBEQACEQEDEQH/xAAdAAABBQEBAQEAAAAAAAAAAAAGAwQFBwgCCQEA/8QAThAAAgEDAQQGBQcHCwQBBAMAAQIDAAQREgUGISIHEzEyQUJRUmFicggUI3GCkrIzgZGiscLwJENTY6HB0dLh4vEVc4Pys0STo9MJFhf/xAAcAQACAwEBAQEAAAAAAAAAAAADBAIFBgEABwj/xAAvEQACAgICAQUAAgAFBQEBAAAAAQIDBBESITEFEyIyQSNRM0JhcYEUUpHB0bFi/9oADAMBAAIRAxEAPwC0Hnr567D9A8Bu7H9lCT7JcSb2SMDJoUmBa6BDpRuvo2A9BzTeFY1Icqj8TPWzZjk/Wa1tk+gUYEr1pH6ez4qT5B+A72dLxz7cGhzZFRCa1bsx7P1aRkHUSQSSubOcTpeFR2e4iyP+yvbJnzP7ONe2RaPxm/0oiZHiJyvXmz0Yn4v2fVUJHkjtyeH6RUUiTOJXyc/nNdRziIazw7PqoqIcT4391dRJx6IDa6EjH5qbgK8ewj6Ptr+Q9o4UrdUdktljzR6gCPRiqqUdANaPwtzihSkSQiYv8KggqOjN+zFEiugDWnstnog3lVkMJwGTs9qt5qRtjpmdz6Gn7hXfyrtwHbq75MkINEgHHCt5qtfTsji+BP0+1Looe0ucj844VdyXZoF/Y71f24oc2FgtCpbNQCaTF0izw9hBPgK85L/k9x4leb0dPH/TzJDZiOWRwUkd+KJy+XT5uarbH9Olev5fBVZOUofU0qiVjJdFkLQWpJFd3pA2PbmbHD2cKBoGlsCOkb8mxIzynhTuI0pFhXHoz/sx+LcPHBrUT8EEiak/49NKpE2ONmnB8O39FDkyYTW1KyJbJBH/AOaholsUD/V+epcT2ztX+vs7ajokfhLxr2juj5O+n0dvbXWejAQW8z/rXke4n43H+leYNIc9fkfszUkiDEpm4f4VwlsSc/VXTqPwf/mvI649EZtBeB9PaPTTlYq4jPdolZcjPt9oo81tAtF2bIlBUfV2VRzXYvJDsyeFJSidQ1l/N7PZUUEQ2dD7KLvRGQpsfbLW8qSr5TzAeK+Za9OvktgbYe7HiaNWKK+tyjYZJY8EH0MtVkZ8HyMhPdEzEO+m577PupLZ86QdcbHzRt3fu9ytXj2+5DkazGtU4IboeHh+ipb2x7W0PbJM9v5znsrrX4ej0VF0v9MajXaWjHIBWWVfE+orfvVe4XpyfzmVubl8PiijYEzjP5yTxY1om+uKKNRf2kelUcXH/GvkEmapvocS3Spw4Z8aDJ7OxrckN5JNXHjjsqUOjvHQH9JWeqb4TTOMv5Byt9GfdkPxbPrHwrVy8A0yabP+hpbRJjvZnbUJsnEI4P7qVbRNj5H/AI9NDR1o6iz/AICponoUBPHt7ONR00dl2dOa90zqi0cTcTg1L25HnJLyz5BsiVjhI2Zs8BpNSVUhWeXXHyxafdi7HEwS47eVM8Ps132pIV/66l+GNUuccGyp7CGGCK7poNG2M/DFXmz6K5JBlF/h8dP49FQcSakkcCuEtEdfn/imYMFJDLZTYk/wFMOXQJItbZF1gCqua2wE0TAn8aUnEDo4Mn91ASCxRzJMP9K6d4kbdXOcijnuJZ/QXvdgm2fHrR59HmWqy6jUvcRQepY3JbJH5S/Rv88tuviB66AF10+ZfOtO4t/tS/0Kv06/hPizJOyrsnwPtzV/rv4my59b/Ct+l7pe0g2tmwz3Zpl8PdRquMLC5PkytycpVr4lN2NpwJbj4nJ7a0zf4ii3vtic02Dw9Hb4/wDtQ9B0emUI0gu35s18ckzUa2yu9rb1a5+qU8c8fZTEa+tlpGKUQ8tIeVfqpVy0ytm+wS6TV+if4T+Gm8aXzG6VtGbtk3PE5x3j41rpeAEX2TwuP+BS2g20SmzXH+ntpeaDR0EEEg/RSrRJ6HayfXXEd0OFfwHsAAGSTUkTY5gsCRqZkQYyNTDPe9VdTavdo0a3ITuyYxfQnbaC+CSRxOQMZpmNCQnZlvXQRWVynALhcHBOntLeWmfBSzdj/Qs2LcYAGBw5ifT8TVFyKi2En5YWQ3Rbu5U4ydPZn1aG5FW4a8MeXGwYZxpnjjkGPOvMPtd6gtko5FkPDK/3x6CyAZLBicDJgkbif+07fhk+9XtbL/D9Ya+NxVj3RUlJAyOODIy4YH1WWvSiaqi2MvlDsTNz/fQHEaUiNvLjt7fbmiwR6TGuypAZB29o4UWa0gUS0bZeUVVuXZCaJK3uP9K9KIvo+zXOP7jSkloJFDSW5J40MNxGcjH2+mjnuItYX7xMsiZDKQwNQl47BW1c46NXbhbxJeQK3bqXDKfA+ZaQUdfFnz/MpdFm0efny1r1Nk3b2VowBuIxctoPNCsrMujl7upl1r7tbb0Wp3R3IuoZm8df2ZStLbPE59OfSdVbFpQWkJrbe5Dx5znSD9Y9AqKPS6GfVceX08TnjXm9Eonox0ibzrBExyOUHFfI6afcejaUw0uTKD6O9oPNdSSuTkngPQNVXuTWoVcQ0Z8ns03ajlX6uNZZ/YTl9gG6T3PVP8Jp3F+45V9TMmxFyx+I4raS8CP6FCoB2enHGlwikP7I/X28BQJoKmTsR+v6j4UroOmSEcnpqEl+hIoeC5MKmdSocNojDcTlkbW+n+rVuVvWdNNB1zI2kHZXPAAZIHix4mrFMQnFE5ZnBzxOeweH/rRVIVnAk7fgOU+JyT4et9qvNifAJNjXXrZIzxHZ/wC1ebEbayxtizasEDHDGf8AbQCktjoJLVPT9WB2n/dURGW2ScRCjw8alFAZJsG98uiqDaaYKsswGI7lFwQfKrt/OJ7v3aZQxjepTx5aM1b/APR9tDZJQ3sYEcjMkc0bq6MV7q6l7rMvPpkrk6kzb4XqlWR8f0F7i+BqEY8S5cpeF4P2xn+lGPSK7OPxOp9l1WNrlR2dlUU3pnX5Ibbd91PE9mO2jx+S0Q4neytpiZeBHsxUbYOLJ8NdjlI+B+qlWFEgM1KLI6Fooc13S/QT2uhPeb5QJ3dgkeMB5phphhZuUP8A0rL3tK03jYEsqxL8Kb1Ciqcfl5MI70byz7QuJru6kaSeZi8kjenuqqr5VXuKvlr6LRTDGr4xKHrwhqZsco4nwx4VNdrYRrSP3zfjpXOSRkjtqctJbfkE+3smNg7jzXs8djag9YzDrpCOWJfN92lrrY1x5TJR3J6NCdKe9rXMnVKeReLEeJ9WsLhU8VyN3Y+HwQ16L+E/6KLnvcNg61ro05s9+QfVWUfkBL7AH0p/k27ew07i/ccq+pm3YqcWx6x7a2UvAlyCSLHj6OzHq0uEWh9YH9uAPTQJsIkT1sOylWw6Q/X0nsxkmht/hNvREXV00hB7FHACjQhrsFOQ6V1UDOPDh6P8zUbQpJj6xBbm448BnjXtAJBHb2fAYHgScHs1VBsAyTs4tBAyeHgDx5vw11sDKOyx93L0KhZsAYySxwO9q/j9+op7KC+sKtlLJOA0ahI88ZnBww9xO83xPy0ZR2U9kuIV2uyI0GeMh8XmOQfhWi6K6U22SMV5nsyfhrvgHrvsb747mQ7UtZrG5xpkXKMDzRSL3JU95W/y15bO03OixSR53b57Bn2ZczWN1nXG2FbGFkRuZJU91l+7R1HZ9MxcuF8E99nW7NzmVcez8VCt+pZ1PbL/ANmLyLWbsXYxLyDHSTDmF+zunGfCnMaPySIyfx2Uf0I9IjdZJC5J0uQD7NVXmZirimKUZHOWjRWoEah2EcazEolihNKgkS0c3+147aKS4mIEcSl2Pp0+Wi11O1qKITaitsw/0ib5y7SuGuXbgxKxxrn6NFblX1fir6NiUKmtL9MZkX+9ZxIltKD+wZ8aaWn5F3HRwEK/GRk+wNXl30jkmF+5O67SsvVglyNIPqn1vs1KycYLlIFFPejU/RjuAmz0GgariVg0jnvE+b4VWsZnXu59+C1qgodlKxJ2k5yScntJoutIv1LYT9HAHX/3CksxfAPUzS2zX5R9XhWWa7AT+wFdKK/RsfYadxV8xmn6ma9kHDP8RxWtl4FUEicf7gKWbCaHtj20CXQWL0TyzADJ8BS+v0NJ/o93sjaAQxHGuSJbhh2FRKraI2+zz/arlT5PZDmpx2RSPnB8ccQOyjeEc3vofW0ROcj25I41JC80E9lYrjJyFwMekn/NUZCrJBHAGrs8SPR937lRa34IpckIbPvmd9CAu/gq4+0zN5V96p8euwF01BFzbsbnY0NdkNpAaNFz1Yb1mVvyj/8Ac5a8mjMZF7mGybSK4HA8OAI44+H+NNEUmVEoD2BS/bkegMeNEBND1UHjnxPb/HNUgDHEcwHZj2Yr22gL7fZD9IfRdZ7YgaC5jUsV+hnVcSwv5WV+8y6u8vdapKbQXHyHjz2jz02dsG42ffSWN0CssMhQ8O+mW0Sr7si861LIXKGz6hgZKvjyNF7JfKL9VZqT29Fq1+g/0iL9Cw9059tNUb5JnP1mH12s9tO0iEjTISQD2jVW7cFbWkzNRk43M1z0Wb+JdxIAcsRjSOJz8NYjLx5Vy1o00LYqO5NBxHAwYqyspxnDKQcfa8tIuMo/h2N0J/VozZ8pvpQ65xs+Bvo4iDOVPfk9T4V/FWt9IwX/AIsvJTZ+SvoimdnQaB7SM8a0UpOSKRJPyfiBnX6DhQfE1NL/AC/hxPQraQkuqDjJIQAB4lq74evwFvZrfou6PBYxKzjVPJgsPEe6tZvNyfcG64cS4dlWYUFjjW3En0D1azls+S0Sl2ZOWIn9NXMn0aOC6CDo+QrcDt7OFJZT+AeCNNbNTKD6qy7fyAT+wF9KT4ib4T205iv5jNP1Mw7IkJZvrJyOwc1bCWtCcfIUxIccD4Uk2MaJCzc9nHt4ChzaaJxh0GO4m7pu7u0tzxV5R1mPUi+kl/VVqUtnxgDyrfbrP3TBtHrL+5OfMq4AxpVOVVX3VWvYcf4+RGmLhBIg4ccB7CcDtx5WajPyN/XsILQaBlvRgA9teQvLsk0v85yNK9o1cWYe6vlX3pKhIDxO9i7NmvX0Q5WJTzuRw+Ff6R/1Vo1fxXYnfP210W9uxsiCzGmJQzHIkc8clu6zt5tLVCUuXgobpuxBHFeN48RnGSOcfAvl+KSuJIrpRSJezxH+cdpOSfibzURJiVg+jvePLxPaQvaPi9WjAHAfwzcRqI4ngF7PvVIXcBxDNg8Afbj+PvV3bASjvtD2C5Knhjt8TUtMFrfkz18sbo4Mj2e24BkwBbW8Cjj1Tvqil/8AHIzI3uvUpP4aNL6HluNnBkNsHiinh2VmLFxZ9InL8IHpKmCwPnHYaYxtuSI+E2ZF6OOiS/29dvBYx8oYme5kBENumrvSv+FY+Zq+gqca602YTLyuEno9HPk89A9lseHq7MdbIeNxtGdAWlfzJao3diVv4es9kXe5LwZ6zJsa02XTHsO2mDRSDX1iFHZ8FmVve/DSzW2ugCutr7i2eMnSBuwbG/v7NyWNvdzwlmPFlSdtLN7zLprZ1te2pR8Giom7PlIjpbnH7SfQK7tLsfffaE4ZQebhgDhnxrq/r9Btl+fJy6L+B2hOM8T1AYdnvVUZuTwXFeQ9NezSOybIZ6x+09gPgKy1k9DTZJO1Kv8AsgjL6xAfsq1bNPFE1uVD9MP0YNI5b+I1BGkNiqdI+qs4/JXWfYE+leDETfVTWL9xmn6mXtjpzN9ZrXy8Af0KI8f28RSjGPwc2Mn7eH1UKQZeUW58neMNeTz4JFtZTPw9aRliX7ylqQy3qrRT5z6Uf7a/+/8AornfHW1w7seLEs3p7zaaaxuoIsddIb7MugpwBjjklhljR5rsn5RPQuOBOS3eCgcR/lX3tdQ0QfTJbZuzZLnGo9XDnDOowzBfIvm0+s33a9vQnOXYe2t8IwsUICp2Kqd4+tp/qm8zSf7aiissiFuyezUcAg5Kjio+H+kb+t/BUkVVyJe2v8nIwuASS57w9X7P/tUuhNx2fE2hrxpJWM5y2OY/Cvq+992pJoE4aJS0vwmAOGOHLxB1d37TV1MBODZKR7Uj4a2C6hkAniSve5e9RExR1MbHabO4OSkeAAueeT3nVe6vu+bzV0hOtImkvAB4jj2+2ipivHZ9faiEFJArxuCrIwyrL5lZWqcdMjxcXtfhT29u7KW02i3B6uQB4UXJxq70S+tpbu/HWZy6pOzaPpHpfqHvUasfjyIT9CHzxQb93jiJBMEH5aQeqz92FW+9TuLD2hLP9X0uFPj+y1919yba0iS3hhjtrZeK21uMBz607d6Rm83WVbSnzXZiJTbly/f7CF7kkYGFXGABwAHu0Dy9g2t9k1u/ABg8PDj6KJ4iQb30eOvS1tv5ztPat0uMS7QunX2r17KrfdWtdXDVKRo8eOkBspBbgD6Tx96pv8LJPoK9w9wJNoXMMK5WIMGlYeKrQLrPahyJxr5s3FsbZSII4kAEcSqoA7OWsdfbyY41xRMyn/ikCK8DdnqR5eTM7SftzirFo0kWT+5L/TL2dvbSGWviNQZpjYi8oz6PGs0/sVdz+QIdLR+hb4abxfuM4/1Mr7HTmf6zwrYy8EP0Iv49tKMY/BW1NQkTRffyYYgIdrScMlraLPjp0yuy1Tepy4qCKTNf8ta/3BPffdnmZ+04JGk5yfd/WqdF3SRdwXJAJYy8xQYyDg6vAeardvaPeAo2TYmXV2pGG5n8ZNPlX3fWaot6Fpy7C2e+C4iQA6l5IxwGO7rf1U93zUNrYm+2SVnHoyclpMePaT5fhRfVryAT7J7Ze1F4mTOoYwE4qNXdVfWX8Pm9apoQthsmuLYaTGc5WMdw+83vMvl/HURVw0OlvBgkkg44g+j+PNUewThs+Q7W0nPYMnIfw973qkmQdTJOK+DHPEHGNTfu+7RkxOcGiQ+fhck419jAeNFE/bbGN5tjGHLDTniPbXthY0o6ikkkOVISPIIkbOW+BO9J+GvO1R8C8qort+AksbNsqeChScO+C51d7T/R/wDj+9QJLn2DU3GPCD/3H0LoO5jUTxY1OK15AN6+v/gWGWP56I/9AXn/AOEJvNvP1TJCo1OxBYDwShTnx1Eex8ZziNN9umOCy2bf36sCILeQRkdjysvUxKnrapmVKNVF2TUAf/StSPI201d5yeJ1E57Szamato3r4l7XHURaxhLsQoLM2SoI7dPrVFdhkbC6ENyTa2yO6gTygFhjioas3nZHJ+2WdK4rZbtpAFGP0+2s/J9g2+TPzrXDqEzHUWzy8mX2j/Z2Va/homFG4VviVT+iq/KfxHYR+JpTZA5B9VZn9Kmz7An0qp9C/b3TTWJ9xqj6sypsaXmf4j+KtpLwC/Sfz9f+FKMaXg+h+H7fbQ39iaNG/JRstdlfNxyb0IfSQluuP/kaqH1RfVmezZatj/yK707Fy2AT2svE9it/l/j30abC6x58lspyHd4dc6PyovBj4ufUXzafWrS1T5RQaQUTX3cRAA2AFRe6qry6m931V+1RVH9Yi2P7ZEhDFjlzjU+clm08un4fL1feqG+fTI8RzZ3JPM2eONKKeaQ+83u+r3Vojjx+oGcSTk27HDp6wkzEHTGiEsq6eZVVfJ6zSVOqqUxWfQ0//wBOgUMuso+O7OhQEr6jN5vVXvVY14SfbE7G/wCiTk3uaN1SaMxB0Z1uXfXGGXyd1dLMrcvWctKvGb2ogVP/AEJa32pHgFWEgyx1qdYHmZdUerq/hoSpkvwm9f2fL/fOCJOseQdXjUXXnxy6u7Hq8vP3O7Ro49j8IE+H6OLDbxn0dSRNrUOjoQUKeV9fd0N61Dsi6n8gUoRCvYm7mriSJMHOpvySH3V/nGXuapOWl3Y5P4lfZJRCiKIJxHO2ASz+B92oRiIzlscqrvxb9A7KPxFd6HsFqBU4pfpDa8yFLy7WGN5X7FBwPSfKq/FXpdeDlEXZPpGaN4uleJ5XhTVcTyviRbc8CWbT1TS+VF8yx8ze5UY18u34NnVjKMeUivflyb1m1sdm7H4Ca5YbQu40/m44NUdrEy+9I0j/APiq39LqTk5/pTxk7Jt/0ZDhiBwmTjIJwOz3q0DWkOce9lqdAW5Pzq61sPo4wHYn3e6tKZtvs18f7G6I8ma92fDk6vAYCj0VjJy32OzH8slA0CSOGeuaOaOWf/So6OaM1yxYHtqxfg0+gq3Fx1i9ntqsyn0WNf1NFbJPIv1Vnt9lHb9gU6VPyL/Cfw01i/cao+rMl7GXnf62rbS8Av0JYm7PrzSjGkfm7PH0UNheXg0H8jfaw07TtDgEPDdqPErIrRSfd0r9+qX1NfFMznqa/ki/9yf6YQ6TwiPAyQSScKA3rN5vh73q+5VYkOWx/CeobKc2/rSVi2GdzlVxgD1W0+VV/WrV0V6SGXLaJOwh6ldTEmRjzHzEt5VqUty7QPR9Vs874znCgcQObur71S1tdEWxzLe9UASCZHOhVB7Dp1aV+7zNRao7ZCa0De8O9SRfRySgSPzSMnGRvViRVVmVfw1ocfGk/BVX2pFRbyb5QNIiJHM8gkU5aQ6TpfkRYlb3V7/NVxTQo9SK6ye14D/e3pJupFghkmjhmfKgaS7jm08qrq9X7XuclMxphHtIrNybADau25keNBM2qQ6mnV9DOVikbTy6dKrp7saOqt3pH7tSlXGf4Q5Ov9B/or3MvtrymYzSRWkbKJ7xmIK/1UCr+WnbVoVY/X5qr8jIqoWgylOfg3v0VbgQ2dtb2+mRLdFIjhkbM8mptWu6b3mbWsCcq1jbrlY/kcsk4lktKoGFAAwAAo8KVWov4ldKTZ9MmcfsosQUuh4JwFLMQqgZLMcKB6zM3Kq1P/YGk5FVdJnylYLNVFmgu3YNiYkiBSvK3MvNI2r+j0L71TcJvyW2J6c7HuRR+095tt7ayHZ1jzwWNTBEB7vmahNQh9maWvHpq6SCGZLDdS3S/vMXN3IQlpaIwDO3nbm7sUfnl0e6vNRK+WRJQr8CWTc7f44GN+kPfq42pd3O0rvHWztnSpOiNF5Yok1d1I10ovwau9WrqqVa1H/kVrgosgoYCQWXOcYFMRW3/sSlL8Ni9B25htbOFCPpZsPIccebm0/ZrMZ1/uT1/RY1LhHZcCW2kAewZqhbIc9iciVKJzkN3X9vZUtEtibfxmo6PbM+3KfV404/Bp0Sm5FziUCq3Jj0PQfRpHZK8i/VWfkuymufzBrpOT6F/hPZTOL9xvH8GRdkvzP8Zxxray8AF5CaI/x40oxlCkIyf24ocv7CpaQZdEm9y7Mv4bmTPUyK1rcEeWObSvW+91bKr/Zpa+Hu18Suz6fcr68mqekHYCyFMhSgQuJQe6e8h1eVdPOrf+tZyhcJ6ZT4tuujNUT5d53xxJKKpzpj8mn3W761qK/p0X2+uQmFdvpWznGFXPBB/u833acrrb8EG/7FhMFGty3YcdWBynT3m1cq/wDkoix7NkJyT8Fb7a6SLlh1KqBIrF45jodgNLLqbq+XTpbvcnwvV9RhKL2U2RkyKvhuzcSPDDI3dd7ic9/q4k1PzNzaeXlWP7VXmklpFK7HJ9kXubtHqutvMc0eVt0Y9jujKkretp1fer29LRN/Lont3tvx6555w0k5imdnzxijRFXRE3ldtWjV5fL39VGr7QK7qPEKtz+jdpLm2nuuu6trYn6EYJluk+gsLVW/oIW1yy+s7+ZKFk2quL4+UIwTt8/U2x0d9G8dpHE0kcadUMQW0I+itw3m/rJ280snNXzu2yU5vl5Y5fcuo1+Ahkn4kk57ePoFQURJd+T5Z3BbB44JPb4V1QOTWvA9vtpGNJJEQyFFLBFITUVXu6m9aoPpkq6nY0mY03h6Ub/acrfPnZIEkdPmdrkRJG3KjOveknhZdeqflbn06K0GNRFR5otp4vsaj/ZZXRvCuowOgcgqyllzwfvaNXvc/wALUr6jHde0HxLNPQS9KfTBYbCjDXP01ywzBYRMA59V52/mYv8AuczeVazuJiXXz78DeTb+IwXvxv1dbVuZL68fU7kKqqMRxRr3Iok8qKv+Zuat5RTHHhpeRCMSHvjjh48DwHhR1trZNoL+i3dU3NzChB6uNg7jwwvN3aFZPhDZxR3I27upEH5x3V5FrF5M9PQ5OaUdBA5/bSaFhtMlHTJjVoqns9sbzV7ZLZnud8+I7OHtpg1GxTdBz84X6qXyI/EZizUew+4v1Vm5rsq7fuD/AEncYX+E5omN9xrH8GPtlJzv8TVt5eAa8hSkf7KUYzEcWicaDLwG1skdp2upD48DQovjLR6Ud9Gr9lbwRR7AtrqXn02SwEE8ZGwYOqLenyfDVFfDd2kZCMGst1/6/wDozZJeCUh+OeDFV8WXup8K1o6I8Y9mjktLiSAdRzSka8AhM4UBu63veamFJyfwPcIRXzKf346SOsNzb6SBE7GSZSOK8vVIunvK3c+krR41c9bkUORdHeoAFu7vO7GSM4AdSEB7fh+Jl7v3auY60VUpSl5Ptpot5HbmaJjEkhXvGKfUrry+q34KNDTAbSG2/uxGtZWw6GJRGYCjjIjlTrotSd5e93tFLzWmShYmuQU9Fe597ejrz1rQvqt4I889w/ebR/VLp55e7Sc8xVvQWNXNcjXXRD0eGHPWy65Yn0kAAqGl0tpRmXVp0qqavNz1X+o5qlX8P0rEkptS8FobbvzHy6iSTkkHsrMpP98IlGLk3/2jSa4I0rxLEDIJ7B6zV5vQWFLmFOw9kcMtxPHA8orjmedXHyTcezyQRgYxgj00KT1HQSM1taMAfKXhfZ91JJGNIZhrXyOjtzKy/hbytzVcelzc3xZp8mvlSrQw6CdvtNE+hj9CG0NnDrG6NInN7vMn2KsMyHKPRSVrjMydvbtAz3M8xYt1kjtliSx5tK6manseCqrTSCWPlMWtYRj2AZx6Kl5PPoiTJli3s7Pw1Lt9Ijs0j0E7qGO3M5HPMdCZ7caqqM23viSrRo/d0rGix+IHHPiWrMWvk9nmnJkmx+r8xpdHhNhU9kxvJRdntDO5Fe2TSM6TSej0cacNUvItui/8oT+yg3/4ZOPk1Nu+ORfqrM2LRWXS7ILpN/It8LGiYr1IYxzIuzYwXc8e83CtxL6kUFUI+qk34GkOtlIA6k4IDAkOMr9pfNQbOgy7JyY6tRcjJJY8MAlvhpTewqiF+zt7E/6bNs+V8ATpd2gHmXrNMyafV5uvX3tdAlDdm0irnjJZCu/8/wDogrWwCASuQG0nPsHq+62nvNVtTTOf16Qa21Rl/wDpR+/W+KXU3VxDqwxmXreckrAup1RdXu+pp1d2tRiYjjHsz2dlJvor6yuWkSaGTVrkMUiADLOItX0XxaZFfT7nrVaxr0VLlyezi7tyJBHw1gogC9iu+lVX/wAde6R3Wye3fvwDMjoZdaFkz2FEgkZ3VvK6qrfvdymIvoFNImt1txottNZT5cQQw/N7xWcGWR4JWW3gi5V1NNCypq8qq/qVWZ2QqonsernLh/Rt3o43SjhAXSqSCPqgsfdgiVeWCL4fO3eZqw8rnZLZY5VnCK14RO7HtFjuJtQwiiOQsfNyMq6ftL3asJyftJGfl/JL/UZX21S5JQYyxwSOAHu1Xzmy9xcR+bPBKbBs9JBPHjli3aS3rUpvsftS46RYNjgY9HhRSgs2Tdjj2VJdrsXe98jIHy5NzdaiQAcVIzjtK81HwZqu412FY78WUGUP8j/bJFy9uST1kMkQyeBbT1icv2ZU+1Wtyl1spGiqts2umeZOI0yOB4cNbd5aLH5QRJ9M4u30oR2Z4A+mo629HVIb7D2K08kNumdUjqDjwXVzVOT0uRD9N0bl7BRDFGO5BGFGfE6axeTa2xnwFdxYauz0+NJxkDctDRrd1/uoiaZ3kJx7XYdo+uiKtMjyOztVT/gajw0TTPkr5FDexmBnRos05I0q8i+6xxcx0G3/AAyUfJqrd3uL2+is3Yytuj2QfSen0LfC2Pu17GXzGMcyHsxed/jNbqX1OIKgcD83HFJvwMoWsZBn/Gl5djEevIebsbK60q7BjCrr1mk4YpqXWqH1tNJy6IznpdATt3be049qiJYzb2JkNoWS11oYWVptLSzqzNqjk/K69K+WrvGxaJU85dy/DO2ZM+en4GHSVvyDK9nZa11HqF68gyqWbq5W+j5V5e63qvVni0Tvlqa0l4IW3qutqXllb7HtU+cxyHKRxq9jaB+BkuJYpGZubvL1knM0nl0Vq/rHRl5t+WB+7l08Sg6gju3VEsMtqXv8zcqtzfzf3qWfJjTluPQhG3UTlJSwZZCJHABKNzKr6fd1a6gtE0+iei2W8j21jblHkkjW3Dgl4xGz9fLcM3qLq5m/qnWp33RrgDhBzZtboP6H47ZYtKjCKy25I5iH/K3z/wBbO3c/oo9FYDKyXa9D1k40x0iy45ooXmuJGWO3gGgu/AFvd9Zm8qx96hQSghGznelBeSq9+ukL50cxXS2cAZVCkAySMzaU699X0aamX6KP7TVJT5dGgxPTI0x3Z5BS76Ub+ykKMkN3GhwxgfEg06VbUv2qkq09lo6uaLf3N6R4LyMSIGjYcGjlGGDf5aTsr0JTx2iydmXhZMj9NDRSW16loZ7y9K1tYLqmLls4WOFC7sfh/wD2VJQlJkI4bt00Za+UJ0wS7WiKRRpBGjEBp5I9Z9blVm01Z49ShNNmgxqHTW4oz58ne6aDalnnxuYUI8Asr9W36slam/5U7KKxaHnSns8RX97Hwx1hdTjtDN/mah0y+CPTAbasuWCjygDh4+9TC6XIEizPk+bA13Mk5AKxJynHDU3q+9SmZZwhoNCOzWe7Fvpj1Htc6j9XlrG2zTGGiSM9L6BOB291kfmqS2Q0R0sIPo9uKOptENDS52fgcP7aaUtnE9EXc3LJ6c0RVphIWaKKmlYejsriXaNcmI7p3x+dxjh2mo5Ef42SrfZsPdcfRr+asfZ5EbvJCdJykRN8JFFo+wxi+TH2zLcl38OZsVs5aUUFS2E/VN2fwaUbcnoZSUV2SnRhf2Zv1hvWbQsM0xji52LW66tLKupm5dT9VHzNoonszcHJFXm5PBaTLo3wufmEMl5MqQW7EvAWykWl/wAlFqZdWrT3l0au/wAtVFdU7Z8fICvJq4dy7Mq9JnSjcbSkuLeC5b5oGV2kOsRqIFVVaLzM0nNpXzaO7W8wPT41LuJT5WRz8Mg9l7V6vQltCfpDHADMS8oil1a55XX+dm5uWPliX3q0kUkukU0tvyKdJ9uLcWSBTySTyAngW6plgVVXy6er71QtZGD5SA69QS2xfskiuTrGeLGeJedV/wC5C2r46W5DEFpnG1d4I5kj61CJ1Ur18Z4yhOVFnTus3k62N9VQbjKJJJx+vgv/AOSf0ZJzXE/EyKGYaX5bZuZIE5dWu7kXm/qIn9es56lc38ENxaguS8m27WeO2hkuJ2EaaclmGNK+qq/qKv2az0YOJU2SldP24eTDnyjuke/u5EIV4bRWCwIDyJrbT1srL3p28zeVeVfftMSEJP5Gsx8X/poL/uKwO4d01xHAxeVnZQqRkmSXVp6rQratWrV3vLo5tFXNcIOPJi+TbOC2y9ulX5M0+xZ7a6sLljFKyrJFcfSEOq6ufTysjNyavK2hqQtuhL4nfTbrL56QW7qbWBbIBXIBxjHl5v1qz0jYSjyWmaJtNqpZ2E15KCViQsqL2yM3KiL8TaUqMY7Zh8v5ZHBGC949t7T2re6b1pY0kk6sQWhwQdelItGrU3l1S+rzVrKcauENolK1w0kBXSnul/0u8mtkcvGCCjHvc3rUWEoTWtDXz8kf0UTkX1tLnsubTUfa95HTc/por5P5Fj9Pthpvrt+HIzpw7RreNl/+SlMf6aOPuJSbP2sfTkZ/Vp6PQGS2ai+T7ur1VmpOdVxJ1h+Hy1n/AFG3cxutaiXu+AMDsAwBWa12TG4k/bUtEj71n/NeI6EZJ8UaKBSQwvtqfszTsIr8F3Ei4pXlOlFLHs4Cjqah9gTKP2jdKAfqxQoo2zZEbp34+eQj21PIj/EyVT7Nsbpdxfq7KxdvkQyPJHdKMI6k/Ua7T9hjDfZkfZJ53+NgK1k98B6K2FFxu6LtHthKbcyBNM4HFNDqzr3uXrF5NVcx/t4F8v4x6JCLeG02OYYrKFLiVdXWTEZJTUzMzzyLyqys3k0+89aKGPO9PXSMrkT11Iqjf3pcv9sXKmdpLi2hfqo7SNikCJLGylYIvLJ1er6eTmZuZm8tXGFh11a0uynl8dvQnv7suCC1kS3nWMLMhaOOHRIupeWKWXUzNP3tTa9OlOVeerSWl4YvCUpPwcbkZf5usYOv6ORYmzmVYEVZUi1d6RZI+v0++9Ei+idjaJvpV6iS1DKBqid0IYYWGS4naSXXKurU2ptCRRv5NXdSgXrQOl/Mo6BiDwJySTzemq6RbpII+jvcz59dIj5FvAOvnIHHQrcsS+9NJpgX4qTy7VTXyRKuPOel4PRrcHd9LO26656uKONWu7mRuCqdHd+GGPTaov3e/WQnKVsuQLKfy9uHkqvbvSLJtabXho7VCfm0LcCR/Tyr67eVfKv26j2vJq/TPTY48ec/sTEm5qyxmMqrp24YDhq/erinrwOTknLbE9ibqXNvIpgJTSGChkBZdXd0u3NR42y15FblVJakFG2lnliPztllYK3MwxpHe0qqt8NRnKLQniwVU9wK3jtyhDHtJ1EUsatfJbNJf9JS72V1TqGXUpKtnSR5dWmjxifOsmftZu2UHtSwmtWLwdXG4Vo1kKCSQcraeeTm5aZWVKC4s0UceFumjN/SPu3MRJc3DmSZmUFmxgaW8qr3aaxrtyC3UcVpAJudPpaFjgH5za8fhuFar2fgzc4dsuf5V6dXdTY/no4JDnxLK0bfF5aVx/AKPgoPYlmJXhixqMsyJjj3VZabnLSZKPZujcvZixhUXuRRqi49NY3IlybY14QQTPSejpws2BjhxI4nt5anojsSmueFe4ntkPeXh7Bkk8AAMk0zGOgUpBju10XvKFefgO0J/mpDJzow+gs5lgWGwIogAij9FU08qc/INs877zauf0HJHjW+VRrXYhtuXPm9h+uo5MNVMnTLczd26T/Rr9VYS5dgsjyMekp8xNj1TUaOpDOIuzIexvyj5zjWc4+L1q2PFcE2MuXF6LGg22EQCK2WR2IRVKmRm5WbU7Nyqq6ebuLVr6d8pa0VHqP8a3Jldb6bY2hciRDNqDyBTDCI44xpXuL1fKyxr32kd9PrVqlFfhk2k3sZdHqQiWSISZ6uNpi0Yx1jqvVusGrlZY42bm+Nuem4LQnZPa0AnSTts3DhAojjQlhGpJCSLyys7/zj8vepSyUtjdUVo43U3wkhGggSqgZ1SRdYT19OnSyrpXXqjdNNR96Uezjg2yw+j7bzbQluorto2gjAS2RgBHG07LolbTzNJ3UaefW2nXzVVZeRNxT/AAZoxVCWyn999myWlxPbzIyPHI40suOGrUrL7reWmabI2RU15/Tsl3o1v8lXoqOmFXB1kpf3ORk62X+R2zfCrdey+s9ZnOv96Tj+LwMbVFXN+WRfypOmz53dx7GtWxa20qi8dGyLi6T+Y1L/ADVt+tJrbyJXqcdwq5y8g/TIOdvNkzuxHpCY8APw1Rzk9n0jXRbG7t8OAOewVDZU5EQx0qRnh2Cu7KRp7B7ei4XTjwrnMfx4dlbbaZcjGOzArzls0NP9GhuiubXs+VfFV1Y9irTq7ifPPVoay1Iqbe4auPj2nHjQX32ajC6joz903XAS3OccWA/Nq1NT+H87BzN1GBQaXASNH9W4g/SrdZ+KtMupGSl4L4+WTCc2Vxw4jqWPaMKkM0X4mqvw/MkAXRXPQVu51l8hPFYEZyfDV3VqeZdwgGpXezZWyLPRGD/SEuPaKyVku9E39j7M3+tSiQY0lmqeiLI+9nwPzUZR/DiDPos3Q6z+UyDhnkDD9aqjOylFcEAn2WyDkY/NgVnVJzF5JRFoNleJp6FQu7TzAu4sZ/aa+kwls1coMjNxLo/P4Bx7SKhl/wCEw+MnzN+bqrmNfqFYG1dhchdjXpFT6Jj7poFXUhnF8mU9yYW6y5zGWiY6ZGLdWFKvqVlf93zVvqV8U5ArtSfXkluk7bGu3igRurWSdAY4AYQY07yu/ebV60mvVV/itSeoIo8qEtfyvoE987zVGkf5GLq9KIgw6wau43mZpGXW3rd5uVNNXMIFBJqL0gg3GjiW56oKAQLewkbh9G1wrSNGvvdXGtqzesr+vTqaSKq1SXaKj39LGdyEAEilnIPY8TNBOzM3Kv0kbO3x1V3R6LWp9DPo02aGlcFDKwRgFJwMMnM2pmXurz/ScrVXZL1DaLOnT8lv7vbZsdlQu0qxXUd3ayq0sckaYkdV0pAq6tTRs2jS+jlSqZ+5f/HHwN2SVfYB7o7HvNuz2ksqNJb7PjihuJFBLSIjyTJE3mZ2XSmnyrTdzWLXpeWK8ozsNO7/APS2dg7HeW2z8/2hIVSQroFvrVlZkVuZpIY15VjTSrOnqVT4tPu2afhAMvd00l4Rj7cKzJVpSSSLlMsxySXRmZmb3mq3zJcY8f8AwW/p0ErFo1HuvJyL29grHTfZuIrosLYt5jH9mfGo7FLobCqz2qcfsBoeypnTpg7vntPSjE+AySK9xHMaC2BVxA7KHAPZqx6BRF4LVaTaNB/J0uQ6SRnGlo3BPpOmm4TWtGD9eraakv7Kv3iuRzewlfr0tp/doO9dF9hrpP8A0Mq/KI2+C0NuD462APYP91aL0unpyFPUr/8AKVnt5cW69nGSNzw9VWX96rNdzKn/ACmivlAQ/OdkWlyvgLSYnxK9V1bfhpHH+NrQpLojPkwbvnqJrk9s8gQH3U5fxUl6rat8EPUL4bNIztgBR4ACs61yfIGM5HBo8CLGUyUYixps3ZpnlSEZ4tzH0LqqNtnCDkcZoSxsBEixrjAAGBWJsm7Z7F5E5ZWQAye3tpuuKRXWT2O5E1U+kKcjyquHzns7OOfTprb/AKfQ0uiR6KdgrJdRvwypIPsqGU9wJU9M2xsBcKB7Oz0VirfsctfJiHSCn0J+o9tDr+4xjPsx/aXLGWQFmIEhwueUfZrZ8m4o646kOukQmNrHWpKyEiMnHKU5mfT3tPkWtH6d9WUfqDB292yeshvrlAI4NCW0ajjdTKmlXZW/mo9Wt28zctX0XozdvZL7lQnrHkUgszwMSzczSxTtI0rL8LNp6v1KajJMTtbQn02bBMkUd5AoZGvHuGjK9xL9I2dWT1Vnhl+/SF8dpncWXz0yv99t1VhFjPDLqNzArXccowsDRcrq/wDV6e75uSqrHscpOD8LwXV8XDTQcbN6I7jbDQLbx9TaLCiW2FwG06tdzOurTrZu9L6vwUO26Nb2v+TkWku/0vHoCa32Lb3iFo5LW2aW5u71ux5NKqqRL3meRlW1iXzd6s/kt5Vi14/D1tSrj/8A0zK/Sbv1c7ZuZru5LIM5trdW1xwR+WJfxs3mar2rHWPHo5W2iW6L7EGG4yOIuYTj7LaqTz2+KZd4D/kL+2HHhV7cY4Vj5+Tcx8BpsubA4/mr2xaxBBZTePDtruivmmJbe2cJFKnHEEV2K0RqloC16OZriYFJJtYjKKsUhSPHe1Mnd1V2L2xyy6FerGWr0b7pT2UDzPNkvGV0quCvNp1M3rf9tKLKKMxnZSvtUEivt7tpLEruThFVnYnsAXmbmoldbk1FFvCft18jEm3tqtdXDzHOXckD1UXuL9la3FEPaq4mQvu9yeyQ2/s/6NF4HgpI/wDEzfvLScX8h5rovCC5+c7uQLxLLDNb8PB4LiPR+rSc3xvbEktsszog3dFtaWkQAGIxIw9DOupv1qzmVb7lzZZ8OMNBtcGgR6QmukM3f+PTRokRpcN+ypR8kAo6H7ANLJKfAaRVV6pZqOj0vBdthbZOo1Q0x2V90uiSjAqxj0V0mKlPRTkexfZ5DJtLUTj24I8a3bgfQ1MPehNz14x4k5OO2kb18QsWbM2JDyisdd9gcmIdIC/QN8J/DS0PuNYb3IyHu/ZjrLi4kB6pJGUDs6x/LAv4392t3XD4InOfyPnSjfkT2XzhTxRpnB4KiM/fdV7qRxryrH8NaH07wzPZ72yvt5doddNPK+HjLgR6eKxxp9GnVequnyx1bKOyhl0gm2bsWWNYLhOIIEuCO8upu78PMnw0dJoG2mwo3P2qjxG2uQTbu6gXC4HBnb6Kdm5o545G5er72vVUbIOXQCUdNNHXR30KSbWupJLoqscs04tFgYTRBFbvMqtq6rTpg+kTvJWdul7S4ryvJdK3de2i+t9Zn2ZFHsq3YTX00cduTCvCCN/o1VPfkXkX1V1t6lZ+c3ZPX/k5RFT/AJH9UZO6T96kklj2VC5+ZwTH5xMndu7tVZWl5e9FC38li8vfk89XFFKrhyf/AAE370+T/AC2CAX48BkqR6NX+6mbJPjtjUYphb0Z3OgXiH1lGPHUiS/5aVympwQ3QuNiL73UvNaKfZmsdd0zcQ8Bhs+YEY9lCXg7NH3aG8SWwDSnSGOkcCcn7PdqUZAJRTOod+bdhkSofEYbJ/VqWxb/AKdsIdzOl6yt5Qc9YcEELgY1LU+TXhFfk+nWZENKRM7c6crIxy28fWsygkELklnbUq6VXTp1e/Ru2VsPSpRmptmZflJ75lIY7UcJLjDyAHiI1but/wBxvwPV76dSpPmzmddwXtooHZMI1/UDk+jl5v8AbV/bMoao9hJvDFkfECqrjtKxLy/q6Kqq38i2a+Ja/QJ9NspoeOUviCB6HVZeb7tL5z4y2LUrcjQOx7fAx6FCjHoWshHvsdyZaehS4PsptdiDY2lFFRAY3h4f31KJMsroOtsxufWc8azvqfc0gVvxiXMkGBj2caXjHjopXLkdpFTMexeQ4KU5HoAeMFveAf2j66+iSj2biqWkXB0KyYeFj5mbBx21S5T1Fj9S2bM3afKVibn2ctTTG3SAq9U2rONLY0AZo2EoKXZKhy2ZT2JtD5zPI7qqW1lzJAnYWZ9Kq3rPNJ32kreQXJKSJSfGQN74XS3U920p1i2s5JXKnGX08kX2ZJF/J+pV1jR4wTM5mWbkV9uxpCB5G71wsaA90CJGZvhVmkWDVVtVErJPey9Ns7tyomzbaPg8FpG8qOMCRLpmbXy+aFmiRvNz0yVkZ62Q+ztlG6VnDFEVitxBKDoMnlZW5dXN3JfLz6qG3xexhT/H/wAF9dF8kUcts1oRot7eW6AjATJSLrEil1d1WaTQzVhvUaOFjtNHVdGWK6kVj0679nZ3WL1iybXvY2a5mX/6GG4XToi9WWSPkXzRR6Gpb06mV8+cvqgdzjGv20ZYa2xoIIHEY4Vppa7f4gVbaXQ8sU4seGCc+0H+O7S8l0NRl2T+wpsSTYI52RxjxOll73xNQLVuGg8Jaey0ej/eT6MAniO2szl06ka7Cv5R0WXsnaGewiq7RZBJcssi8QPYa5x0BWkwb/6aEOQi/ZUcfiWo7aH42xSCfY+8lugH8liZxjGqEuSfeqwha9FfdWm3qR93q29FEJbqZI4lCL9HGoAUcqqun1mby0Rt2SWism/bjrZiHe7eiS9uZriQnLMQo8FRG0oq/CtbHHoVdaMdfZ7lglsm2YMieLSopGO0M3d/DULZfoWqAY30fPCf61wAfefT+qtV0WPSXRafyTLb6G+Q55ZoXHs1LItLeq/RC1b1Yi/7cdv11layWRLs/NH/AMUxHoVTGM8eP76YigWyK2pNymiRiSUi8Pk82ga1D+1vxVnsxN3MVy59aLREOaDFJoqOWkcyELRpS4+AfHYgbknsBoXuSYSMUjxUL+n0nsNfXnE0SnpmiOip1ItwvYq4J8O7WSzXrZosVbRq7dDhGKyN3bOXJpnG/wBnqW+E1GpJSC4r7MbbE2sInvicaMFpB7EfUrfFq7vvV9ExvpFCuXNJgfc3wlt7iReUtJGhIOC6uzN9pY2VftPWhS0oxMvbLlIHHISOBHyMdd1nD1pV5vs9+nISFmumaH23vzJDdwCZC6vChSQEYVeqWJ+X1W5XbzdxvIlMx7KtQ3FskV2DmQSxuWh0vBICOxHibS2nyr1ne6yvWx5QbCU2xjYuQ82Tv8+w5ZyEDqLEJArIJNJe3WNHbrO9FHcRq7Nr7uv1Ky+ZU7kolzJx03DwZa29tOSeWaeaRpZJZGeSRs6pGfvP/t8tPV1xprVcQalyamJy25+hHHiRkn0qtL67b/yj7WtIarIRg8fEECuyR7l2P0lOQwzwGkEdnrL+tS7X4MciXsNtSQgunHS+WXw0vzcvvK1JW4/MscfI9stro/6RI5cAkDhxDHGDVBfjOL6NJTkqaLc2Veo+OYezBpbR6bC/ZGyo2GeGrIPHxrukJWWtE/cWcYHlXAyMdpryTE1ZIy58p/eYg2lsuQGZ7mXHj1C/RJ97nq89Op59sSzLtaRn7Z1kdXHtP9prT2JpJGerluZJbtR67i34H8shIPoV10/qrSFn+G2WNfkM7+34rjjpLvxHqu2mqtMeT2Wn8lCHS20xw7LVuPpdpGofqX0Qk1qxF2WlyunGRnxGaz8Ydgbm+R+ab/im3DoC2NLySpRRDYN7bn5T/dTEUR2aX+T5s/q7CInPNqf7zNWay5J2sQyZbloPVcmq+D2LSiNriYD/ABNTctE4w2Cu9PSVZ2al7m4ihA4/SOAfu11QnP6ofhiOR5I7w7mTQYDoykZJyOFfXIWqXke4praDvoq3m6preNzp5skePMtUWfVy5NF9iS7SZuDdW5BjU+wYrDzXYe+HZ1vhYPNEVBVBghpJDhEHrM3u1OmtORGubiZa2tvJbwiVLGD+SWxluby7u1AkvZokZUVtSt1aNNIqQWsfN32f3PoWNtxSM/kuXNso/d661wMvMWSYMFGSdEqrqb4dVX0tNoQg/wCzi62OZozMhyFdoiAexWTkb7WltVFrej0op7Lx2hfw39kjKyh4E+biSUBCkkUCq8E7/wA31mlXSX1uWmeWynjHhJscbLSWG1Se5deuMYtYY7dkcO6Osizu0bMsnUr3vu+eixBz+U2wm2jvfNM1r1cayCQJb3FtKkZSVPOyO3NDqjZnRtbqzctJ5Ff6FpjqL2Uj0ydGMdjK8lm5a1675vJG+DJaytzKkunvRyLq0S+46tzJSqlyiNVPUtAteqDJaqPULco7e9/lpBLaZfWdOLIBPRkesPRy0cDvsd7OfwGOI4cOyoTX6ST7JXY8560KcYcaSCO3lpO36dD9PHZd26vRxaaFZ4wzEasEnj+tWdsyJp6NBXQmg+2Ru/brjREq+B0kilXZII6wz2feIijhx7R28KG3IFOLCDZRFwcMg7MEgkHH2WqPLRXX860M+kX5JFjtMLIss1vOqaVYHro/W5kbm/8AtvVjiZ3tMymTfZJmU+lH5NO1tk5leIT26k5ubNTIgGnvOn5SP/ycvvVqIZtVq1Fi9M9PsrPca7UzpzDlYMe3sVqneuMC3pmm+iwLyYavzyKT8LNVTLwx+D7LN+T02iDaMg8Wt0B8crBM36upaT9Q8RRHzPZN9RcJzZJz2j0GkUyT0z9//dZY+9n89GS2AdKY9TpDjYc3D00RV6FZ0aI7a23o3Aw44kDj6WqcV5F+EkbY3X0xW0EadgjQcPhrCXWbsaFZV857Y9ubnSCfQMmh676Iwjt6Rkr5Tvyovmoa1spc3JOkiMZMWrzNWj9O9OVj5WeC4rpVfnyY6/6Zc3zme8mklc5/KOSSW+Lu1r/4qVqC6GFU5/bwapu914L6I91jg4K8a9NNLaM5DIdT0zO++u7Bs7y3TGAXUD2ihN/xy2afHu5cWja+4MeYE7e6Kwl/llxc+x7vbbl4xHnGtgmWPKNbadVDob5EIaZkP5UDpbZ2dAVFuLuRlZSrGeSzTqnMunmj0yTSuqv61fTMFNrszF1jmiptw7z5q8kzxiULGVCpJocF+VtLcy93+kTyVc8oisoNBFs/altbRmG0SQrrSaaSd0m0le4n0aqqouptXmZvdqSYPi0L7k7YjjmjSCYj53OxuppVCQhV5uoVJFZZGbzNInn5dC0VS0L2R+OyVtd6nlmTlWFYy8SxY4IzPzrP63XcupvLyafJTCYL2/0ujdRIZI2JBTTI+otxMTdVzKq/Z1r7326jY9iM24y0Asuynfr57vq1UyPY7RQcBJA+lrPa1tq1c2pl63ufSaGbvvVXP4dIs4/2Uvc2DxXfUSjnt2kgYZ8YlkVmVfV89ClDUGy0VvOSREGHBHYOOMZGe7Uv8uyMn2PVs/pMDAz7cZ5dVQn9ScO2Te09lmMWk57ruFJHgVbl/VqvjPk2iydfGKZfu7y4RCc8VVgo7TqrLWt8mainqKDTZtsRgnx7QOwUBhdEjDESRj9FCbITYd7tqEx2eFC2UOSnIsCw2n+yhyejPTp7CrZ9wDwOCCMEHiGHvLU6rHF7ixGyvfgyp8p35ISASbX2NGI5UHWXdnEvLIitqeW2Re7Iq87RR97y81arFzua4zI0WuuXZkePbayvJgjGXYdvnbl/FT7j4NFS9tl9/J4TNlK5/nL6QcPFYEjX96qjPl80iUfq2WVdwDs9tIRFdshtobIUjiB9ZpqLJc2Bm2d0lIOOBxwxR4vrZ73NvR1dblGcWsCDBaZFJA4411VSzOEmiyVceOzeWx9mhEjX1EVePurWUl8m2ZWyzcmkZ2+V70xzWFusNmcXEz9WCOJAbvNVz6Xi+/PsssSnUeTMcWG67Z1OTJPI2qaR+LMzd6tj7qguOui4hV/3E/dbH0FUXtzxxx4UtGTb3+BUtefAT/I63neYPDIc6Byk+Ib3qvcmGjD5i+Ih8rGIRXNgRjUZ+30Dl5ar4LlCRaemT8GnOj38gnZ3V/DWByH82arIemPN8ciPWMZXmAPZleZaXqn8yWP3swR8opM3pOnQzJ1jpnmEk7dxl8ullbSvP9Ho1c1fWcH/AAkZPI+4CvNpCIMd5mY+JbSqqvwqv43p9LYJthNsGDqrC6uSAAbu1iBHjpbrHX3lVdNFa0tA5PbIa0wrTQv+T68SJIoy0ciKzK6r5kZW5lqUZdaJSW0He70kVzIxOG1My9YuRqTSrK3NzdZHq5W8y/BTMWLSXxLI6P7xzN82Ltw1uHfgSUSNUeVPNpVWT3qkxOz6iPS3tcrtHZqLpjinhW2lKgFLmO902k6OmnvqvVTr7qIy8yUhKPTCUvcFsrrp+tEXbt4kR1dWsSyMCMGSLZsMc/8A+RW1e9SUvjU0P4cnyWiv9rW2lwOHYhyMeaJW/eqNcviWVi+QvJlpsKMNqUD7S6aja9RJULcyzekizxZQqo/JSRDV2gnV+L1qzmLZu5mnyK+NWi19yosRKe06QmT2/DVZlS3YWWKv4kGMHDt+oeykdh3EkbPH6OOK9sWktBJs2fsqJVXIMNlz1HRSXRDbY01ciiomGGzpMf60/DorbTzL+W70UDY20zPAmm12gvzmIKMLHKjr84iX3dWmdV9WWtViWe7FR/otsK7aaD35P9njZtjnzi4nIHDjLLy/qqtUOfLlfL/QtvrAsOYUpFi+iNnm8OFORZDRDXr5IUDieUAempWS4xO1R5y7Lr6OOihg0E02QykOq+GdNY++zchi7KSjwRdu1bpY1LnACjJPoCrSdku1ooaoe5Pied3SvvCb++mnzlVYpCp7Bp5dVbXAj7VZsaqOEUhgsQhTWe9jAyO0+tTXLkGa0NrND3m4sxOPYKYititswb+RTeYupVz2qDj06WrRZXaMblv4B98syy57GTsxOAPbqqoofxkM+lv5GjOjaT+Txn3V/DWAvXzZscldj7fB8xEYI4EVCmv5kceWmefnTK7C9umLapHkByDkJyLyr7ys1fW8SOqkZq/7gRbWYcnU+kYZieJY+6q+s3lpqL7AyDja+2RLYdRGoiiim+jiGCxCqvNK/eaVmZnby8qKtTcuxdQA++JCIFyCM6yT2Scvm+FdFRXkIkS+xS0YklQkBEtzlTxMjtp0/aXu+8lMp9kJovfounguHbaQ1I0muJonIwAyc7IvLy6V1tTMvBWW/wBExN0i2CXJ+fh43jIuoQqPNbkW6tHFLzKzL1ass7rB3uqRlqunLSJKuXFJFT71Wc19N1yXGz55Fja3QWZFoSlxO0iM8U+mVpZmmlnZpH9RaUn2tFnjRdWmwM3g2NJCwWZcMTxGckaWbm1LqXy/zb0DwWO+TJzor2D10qM4JAbOD4harfULuEC4wKOU9lm9Lsf0MEYAw9zEoHsVtTVS4P3bLrM+ug+3VtysafUDj06qrr38mP0rVaCR0/xxS2wiexS0m9H6M17YGcSe2bN/pUistiFmybr+6paKe6IfbEm7K9FGeu6DGym/ZT0UVkzPf/8AIVuJ892HJOozJYTR3akdvVs3VT/Z0yK/2Ks/T7OF2v72Tx24y0Vt0WWfV2VpH6trEAPQdCs371Vl0+Vkn/Zq7+oxROTSVxIS5EfdrwpiKIOQt0ebP628tlPd6xWIPjp5qBmWaiHivg5I2GMFlXA4AVj1LlJlG09OTKl+UXvn1UPUIcPKCuR4CiUQ9yev6L/0nG5/yMxhFZgSePbx9vvVsYy+K0adrZ+2pcCRwg4geHopimOxSx6Gu070jgmOwgez1qs64lTawB+Sve6NoKBjDIwOTV1kr4mbv1wZfnytLHXFbOc8syEZHbVJU9NnfS3/ACIuXormzbRfCv4awWStzZuslEzve+IicdnMR6QtBoepgqEYF6e7JVu7l4+x5mUHwK6IWX7WrVX1nAn/ABmdyV8gLSZI1AQFnIA1yDAX4U9b3pPu0/vYk2ObO3bSicNTN2N2ZbzfZ5alIihnd6AsiEnAKtjzB1bS32WXVUUdQR7uQhngt8BhcaGmycBGdNKJq9aNdM6e89NwewFj2g93Z3zjtZBaXaPHMXaFplb6FmZl0SvEq6o2087NG7rz6lXS9FctCEoyl4JTd7qtoLJb3r9X1ElzDDdqokATqmWWJmjXmVo9Tr1iae5zUvNIM3KD1Eow3KBm6vV1bSvJGZMazGrfRdbpXvadNV0y5qW1uZzJtJ5AIgWKgllTJITV3tPq+9QHqI1HbL96K9h9WiH2ACsnm28paRrMOPGO2d703Bub23t149SpkYDsDvyqv3dT0Wj4Vc5EbdWz4ot3ZtsAAPQAB7NNU3Ltlqvrr+h/LH+zjmhM5EaquPR21DZJk1YP2fXU9iNkQi2bcn9n5q9sqLoh3sC88OH+FSh5M9kIO9mS5p5PopZHW9m7SXttc2cgylzby2zA+iWJl/e10WMmmDhLUkYnvN+I7Bls3I1QoI5PSHRlj01yquUuzX2r3dNf0TGzd8LeUcGA9AJontMTcWh/LpYcpB4eBr3cRd7HFhC0BSYHSynKk+mqnMas+Jb40E4Pf6aM6KNvS3UTTzYHlGOwhV71ZuUPbf8AoU+ZWoTUEZu+UjvarXLcwwg08fE1b+m1Oa2avBh7deig7/aukavM+VQez1q1UIdaCTsFrdOqQDiZO1ie3LUyolfZIZ7SvuqUs/aBkD2+WnYIQkwb6DNy5ra/tZX7obmA46dS8tO2ZClEq8mnjWzUfyo9i67EP2kNGw9nOupqpovtiPps+NqCfog428XwL+GsXkvU2bvJkEu+0mm3kf0I7AekqtLUrcwdEjA3TJMesiRgNTCO4JHmZoOZfvV9awo6rM/kv5AJajQ2XwWIDAA5Ab1n/wAlPxYm0PbGTJQ+qHzntLM3L97VUpA30xttiIA6iOPNwPHVzeaoon+D/YG25YT1kXdUMskZwMh2XUrN5mXSro3lo1c9A51cvBfEOz7XbEC3KKWnjVusReSR1g5kSVe7Ivqt3l0adWmmH8itU5Vy0yrekXrLbqBEyxwyLOSkHBQzdXHPzadTLIqr+U1qvPpakJ7LSpKXaKzluB4cMkADwAXuqtAQ39ug26M92TK4YgcSce3T3qqM+5RXRdYVDk+y7d5t547CDUcasaIY170j6e6v71ZmiqV09mjvsjVDR86Gt1pFVrq54zTsZWz2gN5fu8mmi59vJ+3D8F8Wp79xlsQDHpqrT2tFp4Y6Xj+jFDbIsbTx/wCNRJIXtp8Y/Ng13YCaCHZ9x/Br2ytuiGGwrzsP5sVNdMoMivosXYtzwFPw8GctjphRaTUfsR/UYP8AlKbiLDta6BA0XQS8j4eMq6ZV/wDuRtTVMtV7NVhW7rTKi2rsF4/ybEcBjBpqE02OtpghP0l31ow5iQD2HsNWMceM0IWNJm1OiKzN/sxb+5wda/RRqM45tPMvmbVXzr1SxU2+0g3JqSgi4dr7yQ7J2YXkZYwsZPE8dTL3VqnjGV81WgMa3ZfuX4edW8m+73s7zMxEeokBvHm5a+i4uGqIaND72uiY2XDy/OJc9hWMHw9XStNpaFLLBxspjK31ZYk9hqaQpOQH9Il4zHSOzPbntOqnIIAHXRTvbGepbA6zUoYt4GoOrtiGQ9xNHdMymWwcDHFQcCqyXTZS4L1Yv9zvoZf+ToPYKyGSvkz6Df2kwn6SLYtaToO0wyAfXoagYq/mQKt6bZ529JW3BcXOpc6BGgxx4HSrNp+zX1zHjxiZ297kQEdtgKwyefH5lVf3qZ1sg30SWyNmD5wY3ydLlBgYOdSrq+zqoiiCemTNrux84t7l48FopnYFjxKpq5fu1PiQUuJH2aJotXcERuWtZZVySTq5W091m0trT3ldajx7POTLD6OtlDrpIpCIykLIJ0YjSNOmK6Rl95l1f1ejzUx+CthXnSZPMZ/pgOtAKO0YGiRE/JSp1fKysunmTvd6kZR2xuvSiCMMWXGfTnCjJH+6l7ZqKHq4bkW3uvtmdAFtLY57BJcnCj7C81Zy+uMn/IzT48ppaggu3e6MnkkFzeyGebhpDYCR+7EnlqutylBcK1oehjSb3b2WzYKBgf2VTNlklolon/Zwx6agd0Oofz+k1Ii2KSwV4gpDcx+H8Gos6SNjL/ia8hO1BVsu47Pq4GplNfEP9g3ZGP205W9GayYhzs+4yPzU5Ep5dGd/lsbvfR2F+B+Ska2kI7dE69Yn3ZI/16JT50Wvp1nTRmwHrB+j89McdMueXRC3m4yzE5UYHgfStN+9xRyuPJmj+hvpOs9l7NaGbPWRl9MYGSS3d01js/EnlW7XgNdj7kmjO/S50h3u1mxKxWBWysYzgD95qv8AAwq8XteQ3HrQPbrbsoeduWNOIHpNW03yB8tHW2NsGaRI4xwzgAeAXzVOK0gW+w1h2f1EPgCQckduK8kLTkmypNubVDM7HwzoA48fWpqCItjPcvbBWaHjgGSMEj4qaa6YjLuJ6Zbz7sQPYshA/IatXjlU1aqyVtmptFLR1Yv9yuOhrhCvZ2cKzWW9SPolncEyc6X7vTZTks0fJpLxDLgOyry/eqXp8eVyFm9bPNvaMuWYceUEgn1FXvN71fWYfVGfsW2SmztnZ0jIC4PE9hPdapN6R5LaJzdvZpaVrlwdMFtN15GQC8SdTE2rzdZ1kX2qOmKS6Y96OLwW0Su3Nm9CMue8jWs2tG/7ir97RU0z049HV5u7oTaNouk2ugbQtpMnJjV1XUjeVl1aPdkrjfRBS2MNm70skdvOrHrIcxSMo4SR+rKjeZW51bvc7r5EqEJB3BNCe/u7/XA3Nu4k0kFoWOGjilTUjRL5k73vL8NQtfFHKYJtIebgblAENIOOMhR2CsfmZT3o3GJjR6Zdey9nKAMAD0EVnZzku/JexrS78BBEPq7PGhc2vkySbfSHkY8f7aHsnofK/j7RjHhUD2h3G/7e00UHJD1TXgGhQQg/m/ZUWRchSCH+7jXkAkyc2YuDU0V1qC/Y1z2UdMz2REPNkXPZ9VOxfxTM/bHyDnT7ux892Xfwji4h+cR/Hbt1q/e06KPD/ESJ4r42JGEthXRXAYEN2EMOyn5x0X4d2VpqXl7McTjtqqyLuJaYkNjdt2jKfZ4n2UushxXRb+1+ApvXHEp0ZAVcZIqyxpc+xS9KtAxfzF1AjyqA+HjVw4aKRS2wl6Ptzwfp39HDPbQpTO2fFEB0ob8BdUa/CQOwUzTDYlpgJsDd17ojtC9rHjx+GvXW+2OUU8z/2Q==",
        BRIEF_COMMUNITY_USER,
        "LBmB3DGxnNk",
        listOf(INGREDIENT, INGREDIENT),
        listOf("문어 다리를 잘라줍니다.", "문어 다리를 먹으면서 진행합니다.", "문어 머리만 남겨서 맥북 위에 올립니다."),
        listOf(BRIEF_POST, BRIEF_POST, BRIEF_POST),
        MEAT_TYPE,
        10,
        DIFFICULTY,
        1634734699000,
        HEARTED_FALSE,
        ""
    )
}
