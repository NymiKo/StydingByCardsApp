package com.easyprog.cards.fragments.cards_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyprog.cards.R
import com.easyprog.cards.adapters.card_list_adapter.CardsListAdapter
import com.easyprog.cards.adapters.card_list_adapter.WatchCardClickHandler
import com.easyprog.cards.adapters.card_list_adapter.view.CardListViewFactory
import com.easyprog.cards.adapters.card_list_adapter.view.CardsView
import com.easyprog.cards.databinding.FragmentCardsListBinding
import com.easyprog.cards.fragments.detail_card.DetailCardFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsListFragment : Fragment() {

    private var _binding: FragmentCardsListBinding? = null
    private val binding get() = _binding!!
    private val mAdapter = CardsListAdapter()
    private val viewModel by viewModels<CardsListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCardsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupRecyclerView()
        setupView()
        updateDataRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewCardList.adapter = mAdapter
        binding.recyclerViewCardList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun setupView() {
        binding.fabCreateCard.setOnClickListener {
            findNavController().navigate(R.id.createCardFragment)
        }

        mAdapter.attachClickHandler(object : WatchCardClickHandler{
            override fun onCardClick(card: CardsView) {
                val detailCard = DetailCardFragment()
                val bundle = Bundle()
                bundle.putInt(getString(R.string.id_card), card.id)
                detailCard.arguments = bundle
                detailCard.show(requireActivity().supportFragmentManager, detailCard.tag)
            }
        })
    }

    private fun updateDataRecyclerView() {
        viewModel.listOfCards.observe(viewLifecycleOwner, Observer { list ->
            list.forEach { mAdapter.addItem(CardListViewFactory.getView(it)) }
            binding.recyclerViewCardList.smoothScrollToPosition(0)
        })
    }

    override fun onDestroyView() {
        _binding = null
        mAdapter.onDestroy()
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = CardsListFragment()
    }
}