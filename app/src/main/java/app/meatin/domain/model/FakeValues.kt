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
        ""
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
        "https://media.discordapp.net/attachments/880049130813132842/900371003039948830/IMG_2593.png",
        BRIEF_COMMUNITY_USER,
        "https://www.youtube.com/watch?v=LBmB3DGxnNk",
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
