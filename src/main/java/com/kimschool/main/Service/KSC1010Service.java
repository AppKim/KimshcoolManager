package com.kimschool.main.Service;

import java.util.List;

import com.kimschool.main.vo.BoardInfoVo;
import com.kimschool.main.vo.ImageVo;

/**
*
* KSC1010のサービスクラス
* メイン画面に表示するデータ情報処理
*  @author yun
*
*/
public interface KSC1010Service{

	/**
	 *
	 * @return 画面表示用お知らせリスト
	 */
	public List<BoardInfoVo> getList();

	/**
	 *
	 * @return 画面表示用イメージリスト
	 */
	public List<ImageVo> getImgList();
}
