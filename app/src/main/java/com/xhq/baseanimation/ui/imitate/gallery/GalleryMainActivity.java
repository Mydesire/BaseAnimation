package com.xhq.baseanimation.ui.imitate.gallery;

import com.xhq.baseanimation.R;
import com.xhq.baseanimation.adapter.GalleryAdapter;
import com.xhq.baseanimation.ui.base.BaseActivity;

/**
 * 3D图片浏览效果的主页面
 * @author Administrator
 *
 */
public class GalleryMainActivity extends BaseActivity {

	@Override
	public void setView() {
		setContentView(R.layout.activity_imitate_gallery);
		
	}

	@Override
	public void initView() {
	CustomGallery mCustomGallery = findViewById(R.id.custom_gallery);
		
		int[] imageResIDs = getImageResIDs();
		
		GalleryAdapter mAdapter = new GalleryAdapter(this, imageResIDs);
		mCustomGallery.setAdapter(mAdapter);
		
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub
		
	}
	
	
	private int[] getImageResIDs() {
		return new int[]{
				R.drawable.gallery_pic_1,
				R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3,
				R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5,
				R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7,
				R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1,
				R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3,
				R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5,
				R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7,
				R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1,
				R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3,
				R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5,
				R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7,
				R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1,
				R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3,
				R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5,
				R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7,
				R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1,
				R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3,
				R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5,
				R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7,
				R.drawable.gallery_pic_8,
				R.drawable.gallery_pic_1,
				R.drawable.gallery_pic_2,
				R.drawable.gallery_pic_3,
				R.drawable.gallery_pic_4,
				R.drawable.gallery_pic_5,
				R.drawable.gallery_pic_6,
				R.drawable.gallery_pic_7,
				R.drawable.gallery_pic_8
		};
	}
}
