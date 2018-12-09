package com.xhq.baseanimation.ui.listivew.indexlistview;

import android.content.ContentResolver;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.widget.AlphabetIndexer;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AlphabetIndexer,实现了SectionIndexer接口,是adapter的一个辅助类,辅助实现在快滑时，显示索引字母。
 * 使用字母索引的话，必须保证数据列表是按字母顺序排序，以便AlphabetIndexer采用二分查找法快速定位。
 * @author Administrator
 */
class IndexAdapter extends SimpleAdapter implements SectionIndexer{
    
    private AlphabetIndexer alphabetIndexer;
    /**
     * @param context 	  上下文
     * @param data 	 	 ListView中的数据
     * @param resource   ListView中条目的资源id
     * @param from		 Map集合中的键
     * @param to		  条目中子控件的id组成的集合
     */
    public IndexAdapter(Context context,List<? extends Map<String, ?>> data, int resource,String[] from, int[] to) {
        super(context, data, resource, from, to);
        //设置数据游标
        //设置索引字母列表
        /**
         * Cursor表示数据游标
         * sortedColumnIndex按字母索引的游标中的列号
         * alphabet字母列表，用的最多的是"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
         */
        alphabetIndexer = new AlphabetIndexer(new IndexCursor(this), 0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
    
    /**
     * 返回构造函数中指定的由字母构成的区段数组。
     */
    @Override
    public Object[] getSections() {
        return alphabetIndexer.getSections();
    }
    
    /**
     * 执行二进制检索或查找索引来找出匹配给定节首字母的第一行数据
     * @param section	要检索的节索引
     */
    @Override
    public int getPositionForSection(int section) {
        return alphabetIndexer.getPositionForSection(section);
    }
    /**
     * 节索引.如果 position 越界，返回的节索引必须在节数组大小范围内
     * position	要查找的列表位置
     */
    @Override
    public int getSectionForPosition(int position) {
        return alphabetIndexer.getSectionForPosition(position);
    }
    
    /**
     * 伪装一个Cursor供AlphabetIndexer作数据索引源
     */
    private class IndexCursor implements Cursor{
        
        private ListAdapter adapter;
        private int position;
        private Map<String, String> map;
        
        public IndexCursor(ListAdapter adapter){
            this.adapter = adapter;
        }

        @Override
        public int getCount() {return this.adapter.getCount();}


		@Override
		public int getPosition(){
			return 0;
		}


		@Override
		public boolean move(int offset){
			return false;
		}


		/**
         * 取得索引字母，这个方法非常重要，根据实际情况具体处理
         */
        @SuppressWarnings("unchecked")
        @Override
        public String getString(int columnIndex) {
            map = (HashMap<String, String>)adapter.getItem(position);
            return map.get("itemText").substring(0,1);
        }


		@Override
		public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer){

		}


		@Override
		public short getShort(int columnIndex){
			return 0;
		}


		@Override
		public int getInt(int columnIndex){
			return 0;
		}


		@Override
		public long getLong(int columnIndex){
			return 0;
		}


		@Override
		public float getFloat(int columnIndex){
			return 0;
		}


		@Override
		public double getDouble(int columnIndex){
			return 0;
		}


		@Override
		public int getType(int columnIndex){
			return 0;
		}


		@Override
		public boolean isNull(int columnIndex){
			return false;
		}


		@Override
		public void deactivate(){

		}


		@Override
		public boolean requery(){
			return false;
		}


		@Override
		public void close(){

		}


		@Override
		public boolean isClosed(){
			return false;
		}


		@Override
		public void registerContentObserver(ContentObserver observer){

		}


		@Override
		public void unregisterContentObserver(ContentObserver observer){

		}


		@Override
		public void registerDataSetObserver(DataSetObserver observer){

		}


		@Override
		public void unregisterDataSetObserver(DataSetObserver observer){

		}


		@Override
		public void setNotificationUri(ContentResolver cr, Uri uri){

		}


		@Override
		public Uri getNotificationUri(){
			return null;
		}


		@Override
		public boolean getWantsAllOnMoveCalls(){
			return false;
		}


		@Override
		public void setExtras(Bundle extras){

		}


		@Override
		public Bundle getExtras(){
			return null;
		}


		@Override
		public Bundle respond(Bundle extras){
			return null;
		}


		@Override
        public boolean moveToPosition(int position) {
            if(position<-1||position>getCount()){
                return false;
            }

            this.position = position;
            //如果不满意位置有点向上偏的话，下面这几行代码是修复定位索引值为顶部项值的问题
            //if(position+2>getCount()){
            //    this.position = position;
            //}else{
            //   this.position = position + 2;
            //}
            return true;
        }


		@Override
		public boolean moveToFirst(){
			return false;
		}


		@Override
		public boolean moveToLast(){
			return false;
		}


		@Override
		public boolean moveToNext(){
			return false;
		}


		@Override
		public boolean moveToPrevious(){
			return false;
		}


		@Override
		public boolean isFirst(){
			return false;
		}


		@Override
		public boolean isLast(){
			return false;
		}


		@Override
		public boolean isBeforeFirst(){
			return false;
		}


		@Override
		public boolean isAfterLast(){
			return false;
		}


		@Override
		public int getColumnIndex(String columnName){
			return 0;
		}


		@Override
		public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException{
			return 0;
		}


		@Override
		public String getColumnName(int columnIndex){
			return null;
		}


		@Override
		public String[] getColumnNames(){
			return new String[0];
		}


		@Override
		public int getColumnCount(){
			return 0;
		}


		@Override
		public byte[] getBlob(int columnIndex){
			return new byte[0];
		}

	}
}
