package com.example.bookstore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.bookstore.Adapter.CategoryAdapter;
import com.example.bookstore.Adapter.PopularAdapter;
import com.example.bookstore.Domain.BookDomain;
import com.example.bookstore.Domain.CategoryDomain;
import com.example.bookstore.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<BookDomain> booklist = new ArrayList<>();
        booklist.add(new BookDomain("Bố Con Cá Gai","book1",
                "Có những câu chuyện mãi được yêu thương, và nằm trong trái tim bạn đọc suốt năm này qua năm khác… Bố con cá gai là một câu chuyện như thế, trong trái tim độc giả Hàn Quốc, suốt nhiều năm nay. Ở đó có một em nhỏ đã chiến đấu với bệnh hiểm nghèo từ lúc lên ba, giờ em gần mười tuổi. Hãy khoan, đừng vội buồn! Vì em bé này sẽ chẳng làm bạn phải buồn nhiều. Em chịu tiêm rất giỏi, em không khóc, ngoài những lúc mệt quá ngủ thiếp đi, em còn bận đỏ bừng mặt nghĩ tới bạn Eun Mi kẹp-tóc-hoa, bận xếp hình tàu cướp biển, bận lật giở cuốn truyện Bảy viên ngọc rồng… Nhưng bố em thì khác, một ông bố làm em nhỏ của chúng ta phiền lòng quá nhiều, cũng làm những ai dõi theo “bố con cá gai” phải buồn không ít, có khi buồn quá hóa giận! Ông bố ấy đích thị là bố cá gai - một cá bố rất kỳ lạ - cả nguồn sống chỉ co cụm quẩn quanh cá gai con tí xíu. Như một ông bố ngốc!",
                "Cho Chang-In","Novel" ,72.960, 2000, 4.5));
        booklist.add(new BookDomain("Nhà Giả Kim","book2",
                "Tất cả những trải nghiệm trong chuyến phiêu du theo đuổi vận mệnh của mình đã giúp Santiago thấu hiểu được ý nghĩa sâu xa nhất của hạnh phúc, hòa hợp với vũ trụ và con người. Tiểu thuyết Nhà giả kim của Paulo Coelho như một câu chuyện cổ tích giản dị, nhân ái, giàu chất thơ, thấm đẫm những minh triết huyền bí của phương Đông. Trong lần xuất bản đầu tiên tại Brazil vào năm 1988, sách chỉ bán được 900 bản. Nhưng, với số phận đặc biệt của cuốn sách dành cho toàn nhân loại, vượt ra ngoài biên giới quốc gia, Nhà giả kim đã làm rung động hàng triệu tâm hồn, trở thành một trong những cuốn sách bán chạy nhất mọi thời đại, và có thể làm thay đổi cuộc đời người đọc.",
                "Paulo Coelho","Novel" ,51.750, 1988, 4.5));
        booklist.add(new BookDomain("Cây Cam Ngọt Của Tôi","book3",
                "Hãy làm quen với Zezé, cậu bé tinh nghịch siêu hạng đồng thời cũng đáng yêu bậc nhất, với ước mơ lớn lên trở thành nhà thơ cổ thắt nơ bướm. Chẳng phải ai cũng công nhận khoản “đáng yêu” kia đâu nhé. Bởi vì, ở cái xóm ngoại ô nghèo ấy, nỗi khắc khổ bủa vây đã che mờ mắt người ta trước trái tim thiện lương cùng trí tưởng tượng tuyệt vời của cậu bé con năm tuổi. Có hề gì đâu bao nhiêu là hắt hủi, đánh mắng, vì Zezé đã có một người bạn đặc biệt để trút nỗi lòng: cây cam ngọt nơi vườn sau. Và cả một người bạn nữa, bằng xương bằng thịt, một ngày kia xuất hiện, cho cậu bé nhạy cảm khôn sớm biết thế nào là trìu mến, thế nào là nỗi đau, và mãi mãi thay đổi cuộc đời cậu.",
                "Jose Mauro de Vasconcelos","Novel, Art Literature" ,79.920, 2000, 5.0));

        adapter2 = new PopularAdapter(booklist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Novel","cart_1"));
        categoryList.add(new CategoryDomain("Horror","cart_2"));
        categoryList.add(new CategoryDomain("Comic","cart_3"));
        categoryList.add(new CategoryDomain("Detective","cart_4"));
        categoryList.add(new CategoryDomain("Art Literature","cart_5"));
        categoryList.add(new CategoryDomain("Psychology","cart_6"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}