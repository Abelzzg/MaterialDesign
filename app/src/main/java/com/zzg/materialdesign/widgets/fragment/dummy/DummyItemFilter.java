package com.zzg.materialdesign.widgets.fragment.dummy;
//                              _oo0oo_
//                             o8888888o
//                             88" . "88
//                             (| -_- |)
//                             0\  =  /0
//                           ___/'---'\___
//                        .' \\\|     |// '.
//                       / \\\|||  :  |||// \\
//                      / _ ||||| -:- |||||- \\
//                      | |  \\\\  -  /// |   |
//                      | \_|  ''\---/''  |_/ |
//                      \  .-\__  '-'  __/-.  /
//                    ___'. .'  /--.--\  '. .'___
//                 ."" '<  '.___\_<|>_/___.' >'  "".
//                | | : '-  \'.;'\ _ /';.'/ - ' : | |
//                \  \ '_.   \_ __\ /__ _/   .-' /  /
//            ====='-.____'.___ \_____/___.-'____.-'=====
//                              '=---='
//
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//               佛祖保佑          永无BUG       镇类之宝

import com.zzg.materialdesign.widgets.fragment.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abelzzg
 * @version V1.0
 * @Description: com.zzg.materialdesign.widgets.fragment
 * @date 16/1/26 下午4:25
 */
public class DummyItemFilter {

    private final List<DummyContent.DummyItem> mValues;

    public DummyItemFilter(List<DummyContent.DummyItem> values){
        mValues = values;
    }

    public List<DummyContent.DummyItem> filte(String mSearchText) {
        List<DummyContent.DummyItem> newValues = new ArrayList<>();
        for (int i = 0; i < mValues.size(); i++) {
            DummyContent.DummyItem dummyItem = mValues.get(i);
            if (dummyItem.id.contains(mSearchText)||dummyItem.content.contains(mSearchText)){
                newValues.add(mValues.get(i));
            }
        }
        return newValues;
    }
}
