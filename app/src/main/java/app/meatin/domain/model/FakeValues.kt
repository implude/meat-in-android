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
        "",
        "",
        "",
        ""
    )
    val BRIEF_BADGE = BriefBadge(
        "",
        "",
        ""
    )
    val BRIEF_COMMUNITY_USER = BriefCommunityUser(
        "",
        "",
        BRIEF_BADGE,
    )
    val BRIEF_POST = BriefPost(
        "",
        BRIEF_COMMUNITY_USER,
        "주말엔 역시 문어고기",
        "https://media.discordapp.net/attachments/880049130813132842/900371003039948830/IMG_2593.png",
        1634734699000,
        HEARTED_TRUE,
        1,
        "짜잔 맛있는 감자랍니다~"
    )
    val MEAT_TYPE = MeatType(
        "",
        ""
    )
    val DIFFICULTY = Difficulty(
        "",
        0,
    )
    val BRIEF_RECIPE = BriefRecipe(
        "",
        "",
        "",
        MEAT_TYPE,
        0,
        DIFFICULTY,
        0,
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
        listOf(),
        "",
        0,
        BRIEF_COMMUNITY_USER,
        "",
        BRIEF_RECIPE,
        listOf(),
        HEARTED_FALSE,
        false,
        ""
    )
    val RECIPE = Recipe(
        "",
        "",
        "",
        BRIEF_COMMUNITY_USER,
        "",
        listOf(),
        listOf(),
        listOf(),
        MEAT_TYPE,
        0,
        DIFFICULTY,
        0,
        HEARTED_FALSE,
        ""
    )
    val ADVERTISEMENT = AdvertisementModel(
        "",
        "",
        "",
        "",
        ""
    )
}
